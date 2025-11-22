package com.fractal.domain.order.vacation;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.usecase.OrderUseCaseService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.order.vacation.mapper.VacationOrderMapperService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriod;
import com.fractal.domain.vacation_management.accrual.period.VacationAccrualPeriodService;
import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VacationOrderServiceImpl implements VacationOrderService {

    private final VacationOrderRepository orderRepository;
    private final VacationOrderMapperService orderMapperService;
    private final StatusService statusService;
    private final OrderStateService stateService;
    private final VacationService vacationService;
    private final AuthenticatedService authenticatedService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final OrderUseCaseService orderUseCaseService;
    private final FileService fileService;
    private final VacationAccrualPeriodService vacationAccrualPeriodService;

    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public VacationOrder create(VacationOrderRequest dto) {
        var order = orderRepository.save(orderMapperService.toEntity(dto));
        order.setStatus(statusService.getByCode("CREATED"));
        order.getVacation().setStatus(order.getStatus());
        stateService.create(order);
        return order;
    }

    @Override
    public List<VacationOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public VacationOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public VacationOrder update(Long id, VacationOrderRequest dto) {
        var order = getById(id);
        order = orderRepository.save(orderMapperService.toEntity(order,dto));
        return order;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var oder = getById(id);
        vacationService.deleteById(oder.getVacation().getId());
        orderRepository.delete(getById(id));
    }

    @Override
    public VacationOrderResponse toDTO(VacationOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    public VacationOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            order.getVacation().setStatus(order.getStatus());
            stateService.create(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public VacationOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            order.getVacation().setStatus(order.getStatus());
            stateService.create(order);

            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public void print(Long id)  {
        var order = getById(id);
        var request = order.getVacation().getVacationRequest();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();
        var wordFilePath = Path.of(resourceStoragePath + UUID.randomUUID() + ".docx");
        var pdfFilePath =  Path.of(resourceStoragePath + UUID.randomUUID() + ".pdf").toAbsolutePath();

        Map<String, String> values = new HashMap<>();
        values.putAll(orderUseCaseService.getHeader(order));

        values.put("branchName", "DMB");
        values.put("employeeName", employeeUseCaseService.getFullName(order.getVacation().getEmployee()));
        values.put("employeePosition", employment.position().name());
        values.put("fullBankName", employment.organization().name());
        values.put("calendarDays", request.getDays().toString());
        values.put("startDate", request.getStartDate().toString());
        values.put("endDate", request.getEndDate().toString());
        values.put("startDateYear", request.getEndDate().toString());
        values.put("endDateYear", request.getEndDate().toString());
        values.put("returnDay", request.getWorkingDate().toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(request.getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", request.getWorkingDays().toString());
        values.put("sourceDocument", order.getSourceDocument());
        values.putAll(orderUseCaseService.getFooter());

        try {
           wordTemplateProcessorService.process(Path.of(order.getOrderType().getDocumentTemplateManager().getFilePath()), wordFilePath, values);
            wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
            fileService.delete(wordFilePath.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        var vacationAccrual = order.getVacation().getEmployee().getVacationAccruals().stream().findFirst().get();
        vacationAccrualPeriodService.decrease(vacationAccrual.getId(),request.getVacationType().getId(),request.getDays());
    }


}
