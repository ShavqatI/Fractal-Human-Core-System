package com.fractal.domain.order.business_trip;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.location.mapper.BusinessTripLocationMapperService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.order.business_trip.mapper.BusinessTripOrderMapperService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessTripOrderServiceImpl implements BusinessTripOrderService {

    private final BusinessTripService businessTripService;
    private final BusinessTripOrderRepository orderRepository;
    private final BusinessTripOrderMapperService orderMapperService;
    private final OrderStateService stateService;
    private final StatusService statusService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final OrderUseCaseService orderUseCaseService;
    private final FileService fileService;
    private final AuthenticatedService authenticatedService;
    private final BusinessTripLocationMapperService businessTripLocationMapperService;

    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;


    @Override
    @Transactional
    public BusinessTripOrder create(BusinessTripOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
        order.setStatus(statusService.getByCode("CREATED"));
        return save(order);
    }

    @Override
    public List<BusinessTripOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public BusinessTripOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public BusinessTripOrder update(Long id, BusinessTripOrderRequest dto) {
        return save(orderMapperService.toEntity(getById(id), dto));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }



    @Override
    public BusinessTripOrderResponse toDTO(BusinessTripOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    @Transactional
    public BusinessTripOrder save(BusinessTripOrder order) {
        try {
            order = orderRepository.save(order);
            stateService.create(order);
            return order;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public BusinessTripOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public BusinessTripOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.getRecords().forEach(record -> {
                businessTripService.close(record.getBusinessTrip().getId());
            });
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            order.setStatus(order.getStatus());
            return save(order);
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public Path print(Long id)  {
        var order = getById(id);
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();
        var employees = order.getRecords().stream().map(record -> record.getBusinessTrip().getEmployee()).collect(Collectors.toList());
        StringBuilder employeeList = new StringBuilder();
        employees.forEach(employee -> employeeList.append(employeeUseCaseService.getFullName(employee) + "\n"));
        Map<String, String> values = new HashMap<>();

        values.putAll(orderUseCaseService.getHeader(order));

        values.put("calendarDays", order.getDays().toString());
        values.put("startDate", order.startDate.toString());
        values.put("endDate", order.getEndDate().toString());
        values.put("location", getLocation(order));
        values.put("justification", order.getJustification());
        values.put("employeeList", employeeList.toString());
        values.put("sourceDocument", order.getSourceDocument());

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

    private String getLocation(BusinessTripOrder order){
       StringBuilder fullAddress = new StringBuilder();
       var businessTripLocation = order.getRecords().stream().map(record -> record.getBusinessTrip().getLocations().getFirst()).findFirst();
       var businessTripLocationResponse = businessTripLocationMapperService.toDTO(businessTripLocation.get());
       var address = businessTripLocationResponse.addresses().getFirst();
       if (businessTripLocationResponse.locationType().code().equals("INTERNAL")) {
           if(address.district().name() != null)
               fullAddress.append(address.district().name());
           else fullAddress.append(address.city().name());
       }
       else if (businessTripLocationResponse.locationType().code().equals("EXTERNAL"))
           fullAddress.append(address.country().name());

       return fullAddress.toString();
    }

}
