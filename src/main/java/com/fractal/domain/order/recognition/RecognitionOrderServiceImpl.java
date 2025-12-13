package com.fractal.domain.order.recognition;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.Employment;
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
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RecognitionOrderServiceImpl implements RecognitionOrderService {

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


    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;


    @Override
    @Transactional
    public RecognitionOrder create(RecognitionOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
        order.setStatus(statusService.getByCode("CREATED"));
        order = save(order);
        stateService.create(order);
        return order;
    }

    @Override
    public List<RecognitionOrder> getAll() {
        var data = orderRepository.findAll()
                .stream()
                .map(order -> {
                    var newRecords = order.getRecords()
                            .stream()
                            .map(this::setRecord)
                            .toList();

                    order.setRecords(newRecords);
                    order.getRecords().forEach(record->{
                        if(record.getEmployment().getEmployment() instanceof InternalEmployment internalEmployment){
                            System.out.println(record.getEmployment().getEmployment().getClass());
                            internalEmployment.getCompensationComponents().forEach(cc-> System.out.println(cc.getId()));
                        }
                    });
                    return order;
                })
                .toList();
        data.forEach(o->{
            o.getRecords().forEach(record -> {
                if(record.getEmployment().getEmployment() instanceof InternalEmployment internalEmployment){
                    System.out.println(record.getEmployment().getEmployment().getClass());
                    internalEmployment.getCompensationComponents().forEach(cc-> System.out.println(cc.getId()));
                }
            });
        });
       return data;
    }

    @Override
    public RecognitionOrder getById(Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setRecords(
                            order.getRecords().stream()
                                    .map(this::setRecord)
                                    .toList()
                    );
                    return order;
                })
                .orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public RecognitionOrder update(Long id, RecognitionOrderRequest dto) {
        var order = save(orderMapperService.toEntity(getById(id), dto));
        return order;
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
    public Path print(Long id) {
        var order = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();

        Map<String, String> values = new HashMap<>();

        values.putAll(orderUseCaseService.getHeader(order));
        values.putAll(getCommonValues(order));
        values.putAll(templateProcessorService.process(order));
        values.putAll(orderUseCaseService.getFooter());
        try {
            wordTemplateProcessorService.process(Path.of(order.getOrderType().getDocumentTemplateManager().getFilePath()), wordFilePath, values);
            wordToPdfConverterService.convert(wordFilePath, pdfFilePath);
            fileService.delete(wordFilePath.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pdfFilePath;
    }


    @Override
    public RecognitionOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(order);
            order.getRecords().forEach(
                    record -> {
                        compensationComponentService.review(new ApprovalWorkflowAwareRequest(record.getEmployment().getId(),record.getCompensationComponent().getId()));
                    }
            );
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public RecognitionOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(order);
            order.getRecords().forEach(
                    record -> {
                        compensationComponentService.approve(new ApprovalWorkflowAwareRequest(record.getEmployment().getId(),record.getCompensationComponent().getId()));
                    }
            );
            return order;
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

    private Map<String, String> getCommonValues(RecognitionOrder order) {
        Map<String, String> values = new HashMap<>();
        values.put("sourceDocument", order.getSourceDocument());
        values.put("ceo", employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getCEOEmployee()));
        return values;
    }






    private EmployeeEmployment getEmployment(RecognitionOrder order) {
        return order.getRecords().getFirst().getEmployment();
    }

    private EmployeeEmployment getEmployment(RecognitionOrderRecord record) {
        var employment = (Employment) Hibernate.unproxy(record.getEmployment().getEmployment());
        var employeeEmployment = new EmployeeEmployment();
        if (employment instanceof InternalEmployment internalEmployment) {
            List<CompensationComponent> l = new ArrayList<>();
            l.add(record.getCompensationComponent());
            internalEmployment.setCompensationComponents(l);
            employeeEmployment = record.getEmployment();
            employeeEmployment.setEmployment(internalEmployment);
            employeeEmployment.setStatus(record.getEmployment().getStatus());
            employeeEmployment.setEmployee(record.getEmployment().getEmployee());
            employeeEmployment.setStates(record.getEmployment().getStates());
        }
        return employeeEmployment;
    }

    private RecognitionOrderRecord setRecord(RecognitionOrderRecord record) {
        var copy = new RecognitionOrderRecord();
        copy.setCompensationComponent(record.getCompensationComponent());
        copy.setEmployment(getEmployment(record));
        return copy;
    }
}