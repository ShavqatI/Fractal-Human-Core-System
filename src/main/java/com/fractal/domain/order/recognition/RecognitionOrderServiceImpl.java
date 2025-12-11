package com.fractal.domain.order.recognition;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.payment_frequency.PaymentFrequencyService;
import com.fractal.domain.employment.salary_classification.SalaryClassificationService;
import com.fractal.domain.finance.currency.CurrencyService;
import com.fractal.domain.order.recognition.dto.RecognitionOrderRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderResponse;
import com.fractal.domain.order.recognition.dto.RecognitionOrderSalaryRequest;
import com.fractal.domain.order.recognition.dto.RecognitionOrderUploadExcelRequest;
import com.fractal.domain.order.recognition.mapper.RecognitionOrderMapperService;
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
        return orderRepository.findAll();
    }

    @Override
    public RecognitionOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
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
            String path = fileService.save(dto.file(),resourceStoragePath);
            Workbook workbook = excelReaderService.read(Path.of(path));
            Sheet sheet = workbook.getSheetAt(0);
            List<RecognitionOrderRecordRequest> records = new ArrayList<>();

            for(Row row : sheet){
                if (row.getRowNum() == 0) continue;
                try {
                    var employee = employeeService.getByUUID(row.getCell(2).toString());
                    if(employee !=null) {
                        var employeeEmployment = addCompensation(employee.getId(),"ANNUALBONUS","ONE_TIME",BigDecimal.valueOf(row.getCell(3).getNumericCellValue()),dto.startDate(),dto.endDate());
                        records.add(new RecognitionOrderRecordRequest(employeeEmployment.getId()));
                    }
                    var order =create(new RecognitionOrderRequest(
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
                }
                catch (ResourceNotFoundException e){
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
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();

        Map<String, String> values = new HashMap<>();

        values.putAll(orderUseCaseService.getHeader(order));
        values.putAll(getCommonValues(order));
        values.putAll(templateProcessorService.process(order));
        values.putAll(orderUseCaseService.getFooter());
        try {
            wordTemplateProcessorService.process(Path.of(order.getOrderType().getDocumentTemplateManager().getFilePath()), wordFilePath, values);
            wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
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
    public RecognitionOrder decreaseSalary(RecognitionOrderSalaryRequest dto){
        var employeeEmployment = addCompensation(dto.employeeId(),"BASICSALARY","MONTHLY",dto.amount(), dto.startDate(),dto.endDate());
        return create(new RecognitionOrderRequest(
                        dto.orderTypeId(),
                        List.of(new RecognitionOrderRecordRequest(employeeEmployment.getId())),
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
        var employeeEmployment = addCompensation(dto.employeeId(),"BASICSALARY","MONTHLY",dto.amount(), dto.startDate(),dto.endDate());
        return create(new RecognitionOrderRequest(
                        dto.orderTypeId(),
                        List.of(new RecognitionOrderRecordRequest(employeeEmployment.getId())),
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
        var employeeEmployment = addCompensation(dto.employeeId(),"ADDITIONALSALARY","MONTHLY",dto.amount(), dto.startDate(),dto.endDate());
        return create(new RecognitionOrderRequest(
                        dto.orderTypeId(),
                        List.of(new RecognitionOrderRecordRequest(employeeEmployment.getId())),
                        dto.number(),
                        dto.date(),
                        dto.sourceDocument(),
                        dto.justification(),
                        List.of()
                )
        );
    }
    private EmployeeEmployment addCompensation(Long employeeId,String salaryClassification, String paymentFrequency, BigDecimal amount,LocalDate startDate, LocalDate endDate) {
        var employeeEmployment = employeeEmploymentService.addCompensation(employeeId,new CompensationComponentRequest(
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
        return employeeEmployment;
    }

    private Map<String,String> getCommonValues(RecognitionOrder order){
        Map<String, String> values = new HashMap<>();
        var employeeEmployment = getEmployment(order);
        getCompensationComponent(employeeEmployment);

        var employment = employeeEmploymentService.getEmployment(employeeEmployment).get();
        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("sourceDocument", order.getSourceDocument());
        values.put("ceo",employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getCEOEmployee()));
        return values;
    }
    private EmployeeEmployment getEmployment(RecognitionOrder order){
        return order.getRecords().getFirst().getEmployment();
    }

    private CompensationComponent getCompensationComponent(EmployeeEmployment employeeEmployment){
        if(employeeEmployment.getEmployment() instanceof InternalEmployment){
            System.out.println("Yes it is instance");
        }
        return null;
    }

}
