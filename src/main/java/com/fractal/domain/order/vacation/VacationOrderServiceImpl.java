package com.fractal.domain.order.vacation;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.order.vacation.mapper.VacationOrderMapperService;
import com.fractal.domain.poi.processor.word.WordTemplateProcessorService;
import com.fractal.domain.poi.processor.word.WordToPdfConverterService;
import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        var wordFilePath = Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\test_temp2.DOCX");
        var pdfFilePath =  Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\test_temp2.pdf");
        Map<String, String> values = new HashMap<>();

        values.put("number",order.getNumber());
        values.put("docDate", order.getDate().toString());
        values.put("branchName", "DMB");
        values.put("employeeName", employeeUseCaseService.getFullName(order.getVacation().getEmployee()));
        values.put("employeePosition", "Officer");
        values.put("fullBankName", "CJSC ICB");
        values.put("calendarDays", order.getVacation().getVacationRequest().getDays().toString());
        values.put("startDate", order.getVacation().getVacationRequest().getStartDate().toString());
        values.put("endDate", order.getVacation().getVacationRequest().getEndDate().toString());
        values.put("returnDay", order.getVacation().getVacationRequest().getEndDate().plusDays(1L).toString());
        values.put("successorEmployeeName", employeeUseCaseService.getFullName(order.getVacation().getVacationRequest().getSuccessorEmployee()));
        values.put("percent", order.getVacation().getSuccessorCompensationPercentage().toString());
        values.put("workingDays", "T1212");
        values.put("sourceDocument", "T4564646");
        values.put("hrHead", "test head");

        try {
            wordTemplateProcessorService.process(Path.of(order.getOrderType().getDocumentTemplateManager().getFilePath()), wordFilePath, values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        wordToPdfConverterService.convert(wordFilePath,pdfFilePath);
    }
}
