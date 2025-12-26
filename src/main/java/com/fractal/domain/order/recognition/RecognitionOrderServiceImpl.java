package com.fractal.domain.order.recognition;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponentService;
import com.fractal.domain.employment.internal.compensation_component.dto.ApprovalWorkflowAwareRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.payment_frequency.PaymentFrequencyService;
import com.fractal.domain.employment.salary_classification.SalaryClassificationService;
import com.fractal.domain.finance.currency.CurrencyService;
import com.fractal.domain.order.recognition.dto.RecognitionOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;
import com.fractal.domain.order.recognition.dto.RecognitionOrderSalaryRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderUploadExcelRequest;
import com.fractal.domain.order.recognition.mapper.RecognitionOrderMapperService;
import com.fractal.domain.order.recognition.record.RecognitionOrderRecord;
import com.fractal.domain.order.recognition.record.dto.RecognitionOrderRecordRequest;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.poi.processor.excel.ExcelReaderService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlObject;
import org.hibernate.Hibernate;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class RecognitionOrderServiceImpl implements RecognitionOrderService {

    private final RecognitionOrderRepository orderRepository;
    private final RecognitionOrderMapperService orderMapperService;
    private final OrderStateService stateService;
    private final StatusService statusService;
    private final AuthenticatedService authenticatedService;
    private final ExcelReaderService excelReaderService;
    private final FileService fileService;
    private final EmployeeService employeeService;
    private final EmployeeEmploymentService employeeEmploymentService;
    private final SalaryClassificationService salaryClassificationService;
    private final PaymentFrequencyService paymentFrequencyService;
    private final CurrencyService currencyService;
    private final RecognitionOrderTemplateProcessorService templateProcessorService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final OrderUseCaseService orderUseCaseService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;
    private final CompensationComponentService compensationComponentService;
    private final DocumentTemplateManagerService documentTemplateManagerService;


    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;


    @Override
    @Transactional
    public RecognitionOrder create(RecognitionOrderRequest dto) {
        return save(orderMapperService.toEntity(dto));
    }

    @Override
    public List<RecognitionOrder> getAll() {
        return orderRepository.findAll().stream().map(order -> copy(order)).collect(Collectors.toList());
    }

    @Override
    public RecognitionOrder getById(Long id) {
        return orderRepository.findById(id).map(order -> copy(order)).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public RecognitionOrder update(Long id, RecognitionOrderRequest dto) {
        return save(orderMapperService.toEntity(getById(id), dto));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }

    @Override
    public List<RecognitionOrder> createFromExcelFile(RecognitionOrderUploadExcelRequest dto) {
        List<RecognitionOrder> recognitionOrders = new ArrayList<>();
        try {
            String path = fileService.save(dto.file(), resourceStoragePath);
            Workbook workbook = excelReaderService.read(Path.of(path));
            Sheet sheet = workbook.getSheetAt(0);
            List<RecognitionOrderRecordRequest> records = new ArrayList<>();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;
                try {
                    var employee = employeeService.getByUUID(row.getCell(2).toString());
                    if (employee != null) {
                        var compensation = addCompensation(employee.getId(), "ANNUALBONUS", "ONE_TIME", BigDecimal.valueOf(row.getCell(3).getNumericCellValue()), dto.startDate(), dto.endDate());
                        var employeeEmployment = employeeEmploymentService.getByCompensationComponentId(compensation.getId());
                        records.add(new RecognitionOrderRecordRequest(employeeEmployment.getId(), compensation.getId()));
                    }
                    var order = create(new RecognitionOrderRequest(
                            dto.orderTypeId(),
                            records,
                            dto.number(),
                            dto.date(),
                            dto.sourceDocument(),
                            dto.justification(),
                            List.of()
                            )
                    );
                    recognitionOrders.add(order);
                } catch (ResourceNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                return recognitionOrders;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public RecognitionOrderResponse toDTO(RecognitionOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    public RecognitionOrder save(RecognitionOrder order) {
        try {
            order = orderRepository.save(order);
            stateService.create(order);
            return order;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    @Transactional
    public RecognitionOrder review(Long id) {
        var order = finById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            order.getRecords().forEach(
                    record ->
                            compensationComponentService.review(new ApprovalWorkflowAwareRequest(record.getEmployment().getEmployment().getId(), record.getCompensationComponent().getId()))
            );
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    @Transactional
    public RecognitionOrder approve(Long id) {
        var order = finById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            order.getRecords().forEach(
                    record -> compensationComponentService.approve(new ApprovalWorkflowAwareRequest(record.getEmployment().getEmployment().getId(), record.getCompensationComponent().getId()))
            );
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public RecognitionOrder cancel(Long id) {
        return null;
    }

    @Override
    public RecognitionOrder decreaseSalary(RecognitionOrderSalaryRequest dto) {
        var compensation = addCompensation(dto.employeeId(), "BASICSALARY", "MONTHLY", dto.amount(), dto.startDate(), dto.endDate());
        var employeeEmployment = employeeEmploymentService.getByCompensationComponentId(compensation.getId());
        return create(new RecognitionOrderRequest(
                        dto.orderTypeId(),
                        List.of(new RecognitionOrderRecordRequest(employeeEmployment.getId(), compensation.getId())),
                        dto.number(),
                        dto.date(),
                        dto.sourceDocument(),
                        dto.justification(),
                        List.of()
                )
        );
    }

    @Override
    public RecognitionOrder increaseSalary(RecognitionOrderSalaryRequest dto) {
        var compensation = addCompensation(dto.employeeId(), "BASICSALARY", "MONTHLY", dto.amount(), dto.startDate(), dto.endDate());
        var employeeEmployment = employeeEmploymentService.getByCompensationComponentId(compensation.getId());
        return create(new RecognitionOrderRequest(
                        dto.orderTypeId(),
                        List.of(new RecognitionOrderRecordRequest(employeeEmployment.getId(), compensation.getId())),
                        dto.number(),
                        dto.date(),
                        dto.sourceDocument(),
                        dto.justification(),
                        List.of()
                )
        );
    }

    @Override
    public RecognitionOrder surcharge(RecognitionOrderSalaryRequest dto) {
        var compensation = addCompensation(dto.employeeId(), "ADDITIONALSALARY", "MONTHLY", dto.amount(), dto.startDate(), dto.endDate());
        var employeeEmployment = employeeEmploymentService.getByCompensationComponentId(compensation.getId());
        return create(new RecognitionOrderRequest(
                        dto.orderTypeId(),
                        List.of(new RecognitionOrderRecordRequest(employeeEmployment.getId(), compensation.getId())),
                        dto.number(),
                        dto.date(),
                        dto.sourceDocument(),
                        dto.justification(),
                        List.of()
                )
        );
    }

    private CompensationComponent addCompensation(Long employeeId, String salaryClassification, String paymentFrequency, BigDecimal amount, LocalDate startDate, LocalDate endDate) {
        var compensationComponent = employeeEmploymentService.addCompensation(employeeId, new CompensationComponentRequest(
                        salaryClassificationService.getByCode(salaryClassification).getId(),
                        paymentFrequencyService.getByCode(paymentFrequency).getId(),
                        startDate,
                        endDate,
                        currencyService.getByCode("TJS").getId(),
                        amount,
                        null,
                        null,
                        null,
                        null
                )
        );
        if (compensationComponent.isPresent()) return compensationComponent.get();
        return null;
    }

    @Override
    public Path print(Long id) {
        var order = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();
        Map<String, String> values = new HashMap<>();
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(order.getOrderType().getDocumentTemplateManager().getFilePath()));
            values.putAll(orderUseCaseService.getHeader(order));

            switch (order.getOrderType().getCode()) {
                case "EMPBONUSPAY":
                    document = templateProcessorService.getTenYearServiceBonusValues(document, order);
                    break;
                case "NEWCUSTBONUS":
                    document = templateProcessorService.getNewCustomersBonusValues(document, order);
                    break;
                case "LOANBONUS":
                    document = templateProcessorService.getLoanRecoveryBonusValues(document, order);
                    break;
                case "CSBONUS":
                    document = templateProcessorService.getCustomerServiceBonusValues(document, order);
                    break;
                case "DFSBONUS":
                    document = templateProcessorService.getDFSBonusValues(document, order);
                    values.put("startDate", order.getRecords().getFirst().getCompensationComponent().getStartDate().toString());
                    values.put("endDate", order.getRecords().getFirst().getCompensationComponent().getEndDate().toString());
                    break;
                case "TREASBONUS":
                    document = templateProcessorService.getTreasureBonusValues(document, order);
                    break;
                case "REMITTBONUS":
                    document = templateProcessorService.getRemittanceBonusValues(document, order);
                    break;

                default:
                    values.putAll(templateProcessorService.process(order));
            }
            values.putAll(orderUseCaseService.getFooter());
            //setStamp(document);
            setFloatingStamp(document);
            findTextBoxes(document);
            //insertImageAtBookmark(document);
            //findTextInTextBoxes(document, "myText");
            //findTextBoxes(document);
            //findAllTextBoxes(document);

            wordTemplateProcessorService.processDocument(document, values);

            try (FileOutputStream out = new FileOutputStream(wordFilePath.toFile())) {
                document.write(out);
                wordToPdfConverterService.convert(wordFilePath, pdfFilePath);
                //fileService.delete(wordFilePath.toString());
            }


        } catch (Exception e) {
        }
        return pdfFilePath;
    }

    public void setStamp(XWPFDocument document) {
      XWPFTable table = document.getTables().get(document.getTables().size() - 1);

      outerLoop:
        for (XWPFTableRow row : table.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                for (XWPFParagraph paragraph : cell.getParagraphs()) {
                    for (XWPFRun run : paragraph.getRuns()) {

                        String text = run.getText(0);
                        if (text != null && text.contains("${STAMP}")) {
                            run.setText(text.replace("${STAMP}", ""), 0);

                            try (InputStream is = new FileInputStream(documentTemplateManagerService
                                            .getByCode("DIGITALSTAMP")
                                            .getFilePath())) {

                                run.addPicture(
                                        is,
                                        Document.PICTURE_TYPE_PNG,
                                        "stamp.png",
                                        Units.toEMU(100),
                                        Units.toEMU(100)
                                );

                            } catch (Exception e) {
                                throw new RuntimeException("Failed to insert stamp image", e);
                            }

                            break outerLoop;
                        }
                    }
                }
            }
        }
    }

    public void setFloatingStamp(XWPFDocument document) throws Exception {
        XWPFTable table = document.getTables().get(document.getTables().size() - 1);

        outerLoop:
        for (XWPFTableRow row : table.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                for (XWPFParagraph paragraph : cell.getParagraphs()) {
                    for (XWPFRun run : paragraph.getRuns()) {

                        String text = run.getText(0);
                        if (text != null && text.contains("${STAMP}")) {
                            run.setText(text.replace("${STAMP}", ""), 0);

                            try (InputStream is = new FileInputStream(
                                    documentTemplateManagerService.getByCode("DIGITALSTAMP").getFilePath())) {

                                // Convert image to bytes
                                byte[] bytes = is.readAllBytes();

                                // Add picture with a placeholder inline (we will replace it)
                                int pictureType = Document.PICTURE_TYPE_PNG;
                                String filename = "stamp.png";

                                String blipId = run.getDocument().addPictureData(bytes, pictureType);
                                int width = Units.toEMU(100);  // width in EMUs
                                int height = Units.toEMU(100); // height in EMUs

                                // Create anchor (floating image)
                                CTInline inline = run.getCTR().addNewDrawing().addNewInline();
                                CTNonVisualDrawingProps docPr = inline.addNewDocPr();
                                docPr.setId(1);
                                docPr.setName(filename);

                                CTPositiveSize2D extent = inline.addNewExtent();
                                extent.setCx(width);
                                extent.setCy(height);

                                // Add graphic data
                                CTGraphicalObject graphic = inline.addNewGraphic();
                                CTGraphicalObjectData graphicData = graphic.addNewGraphicData();
                                graphicData.setUri("http://schemas.openxmlformats.org/drawingml/2006/picture");

                                // You need to create the <pic> element here manually
                                // This is verbose; the easiest alternative is to use `XWPFPicture` + CTAnchor:
                                XWPFPicture picture = run.addPicture(
                                        new FileInputStream(documentTemplateManagerService.getByCode("DIGITALSTAMP").getFilePath()),
                                        pictureType, filename, Units.toEMU(100), Units.toEMU(100)
                                );

                                // Make it floating (in front of text)
                                picture.getCTPicture().getBlipFill().getBlip().setEmbed(blipId);
                                picture.getCTPicture().getSpPr().addNewXfrm().addNewOff().setX(0);
                                picture.getCTPicture().getSpPr().getXfrm().getOff().setY(0);

                                break outerLoop;

                            } catch (Exception e) {
                                throw new RuntimeException("Failed to insert stamp image", e);
                            }
                        }
                    }
                }
            }
        }
    }




   private RecognitionOrder copy(RecognitionOrder order) {
        Map<Long, InternalEmployment> employmentCache = new HashMap<>();
        List<RecognitionOrderRecord> newRecords = new ArrayList<>();
        order.getRecords().forEach(record ->
                {
                    var originalEmployment =
                            (InternalEmployment) Hibernate.unproxy(
                                    record.getEmployment().getEmployment()
                            );

                    // one InternalEmployment per id
                    InternalEmployment employmentCopy =
                            employmentCache.computeIfAbsent(
                                    originalEmployment.getId(),
                                    id -> employeeEmploymentUseCaseService.copy(originalEmployment)
                            );

                    // aggregate components
                    employmentCopy.addCompensationComponent(
                            record.getCompensationComponent()
                    );

                    // rebuild EmployeeEmployment
                    EmployeeEmployment ee = new EmployeeEmployment();
                    ee.setEmployment(employmentCopy);
                    ee.setEmployee(record.getEmployment().getEmployee());
                    ee.setStatus(record.getEmployment().getStatus());
                    ee.setStates(record.getEmployment().getStates());

                    // rebuild record
                    RecognitionOrderRecord recordCopy = new RecognitionOrderRecord();
                    recordCopy.setCompensationComponent(record.getCompensationComponent());
                    recordCopy.setEmployment(ee);

                    newRecords.add(recordCopy);
                }

        );
        order.setRecords(newRecords);
        return order;
    }

    private RecognitionOrder finById(Long id){
        return orderRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    public void findTextBoxes(XWPFDocument document) {
        for (XWPFParagraph p : document.getParagraphs()) {
            for (XWPFRun run : p.getRuns()) {
                // Check if run has drawing
                List<CTDrawing> drawings = run.getCTR().getDrawingList();
                for (CTDrawing drawing : drawings) {
                    System.out.println(drawing.getClass());
                }
            }
        }



    }

    public void findAllTextBoxes(XWPFDocument document) {
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            for (XWPFRun run : paragraph.getRuns()) {
                CTR ctr = run.getCTR();

                // 1️⃣ Modern text boxes inside mc:AlternateContent
                XmlObject[] drawings = ctr.selectPath(
                        "declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' " +
                                "declare namespace wps='http://schemas.microsoft.com/office/word/2010/wordprocessingShape' " +
                                ".//mc:AlternateContent//wps:wsp//wps:txbx//w:txbxContent//w:p//w:r//w:t"
                );

                for (XmlObject obj : drawings) {
                    System.out.println("TextBox content (modern): " + obj.xmlText());
                }

                // 2️⃣ Legacy text boxes in w:pict
                XmlObject[] legacyText = ctr.selectPath(
                        "declare namespace v='urn:schemas-microsoft-com:vml' " +
                                "declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' " +
                                ".//w:pict//v:shape//v:textbox//w:txbxContent//w:p//w:r//w:t"
                );
                for (XmlObject obj : legacyText) {
                    System.out.println("TextBox content (legacy): " + obj.xmlText());
                }
            }
        }
    }









}