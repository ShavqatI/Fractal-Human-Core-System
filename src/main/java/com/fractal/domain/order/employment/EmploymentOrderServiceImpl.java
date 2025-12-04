package com.fractal.domain.order.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import com.fractal.domain.order.employment.dto.EmploymentOrderHireRequest;
import com.fractal.domain.order.employment.dto.EmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.EmploymentOrderResponse;
import com.fractal.domain.order.employment.mapper.EmploymentOrderMapperService;
import com.fractal.domain.order.employment.record.dto.EmploymentOrderRecordRequest;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmploymentOrderServiceImpl implements EmploymentOrderService {

    private final EmploymentOrderRepository orderRepository;
    private final EmploymentOrderMapperService orderMapperService;
    private final OrderStateService stateService;
    private final StatusService statusService;
    private final AuthenticatedService authenticatedService;
    private final EmployeeEmploymentUseCaseService employmentUseCaseService;
    private final OrderUseCaseService orderUseCaseService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final EmploymentOrderTemplateProcessorService templateProcessorService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final FileService fileService;
    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;

    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;


    @Override
    @Transactional
    public EmploymentOrder create(EmploymentOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
        order.setStatus(statusService.getByCode("CREATED"));
        order = save(order);
        stateService.create(order);
        return order;
    }

    @Override
    public List<EmploymentOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public EmploymentOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public EmploymentOrder update(Long id, EmploymentOrderRequest dto) {
        var order = save(orderMapperService.toEntity(getById(id), dto));
        return order;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }

    @Override
    public EmploymentOrderResponse toDTO(EmploymentOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    public EmploymentOrder save(EmploymentOrder order) {
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
    public EmploymentOrder hire(EmploymentOrderHireRequest dto) {
        var employment = employmentUseCaseService.hire(dto.employeeId(),dto.hire());
        return create(new EmploymentOrderRequest(
                dto.orderTypeId(),
                List.of(new EmploymentOrderRecordRequest(employment.getId())),
                dto.number(),
                dto.date(),
                dto.sourceDocument(),
                List.of()
        ));
    }

    @Override
    public EmploymentOrder transfer(EmploymentOrderHireRequest dto) {
        var employment = employmentUseCaseService.hire(dto.employeeId(),dto.hire());
        return create(new EmploymentOrderRequest(
                dto.orderTypeId(),
                List.of(new EmploymentOrderRecordRequest(employment.getId())),
                dto.number(),
                dto.date(),
                dto.sourceDocument(),
                List.of()
        ));

    }


    @Override
    public EmploymentOrder review(Long id) {
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
    public EmploymentOrder approve(Long id) {
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

    private Map<String,String> getCommonValues(EmploymentOrder order){
        Map<String, String> values = new HashMap<>();
        var employeeEmployment = getEmployment(order);

        var employment = employeeUseCaseService.getCurrentEmployment(employeeEmployment.getEmployee()).get();

        values.put("employeeName", employeeUseCaseService.getFullName(employeeEmployment.getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("ceo",employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getCEOEmployee()));


        return values;
    }

    private EmployeeEmployment getEmployment(EmploymentOrder order){
        return order.getRecords().getFirst().getEmployment();
    }
}
