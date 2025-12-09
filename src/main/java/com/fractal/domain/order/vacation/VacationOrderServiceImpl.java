package com.fractal.domain.order.vacation;

import com.fractal.domain.abstraction.AbstractEntity;
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
import com.fractal.domain.vacation_management.accrual.VacationAccrualService;
import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
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
    private final VacationRequestService vacationRequestService;
    private final WordTemplateProcessorService wordTemplateProcessorService;
    private final WordToPdfConverterService wordToPdfConverterService;
    private final EmployeeUseCaseService employeeUseCaseService;
    private final OrderUseCaseService orderUseCaseService;
    private final FileService fileService;
    private final VacationAccrualPeriodRecordService vacationAccrualPeriodRecordService;
    private final AuthenticatedService authenticatedService;
    private final VacationAccrualService vacationAccrualService;
    private final VacationTypeService vacationTypeService;
    private final VacationOrderTemplateProcessorService templateProcessorService;




    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public VacationOrder create(VacationOrderRequest dto) {
        var order = save(orderMapperService.toEntity(dto));
        order.setStatus(statusService.getByCode("CREATED"));
        order.getVacation().setStatus(order.getStatus());
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
        order = orderMapperService.toEntity(order,dto);
        order.getVacation().setStatus(order.getStatus());
        return save(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var oder = getById(id);
        vacationService.deleteById(oder.getVacation().getId());
        orderRepository.delete(getById(id));
    }

    private VacationOrder save(VacationOrder order) {
        try {
            order = orderRepository.save(order);
            stateService.create(order);
            return order;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
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
            return save(order);
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
            vacationService.close(order.getVacation().getId());
            vacationRequestService.close(order.getVacation().getVacationRequest().getId());


            order.getVacation().getAllocations().forEach(allocation -> vacationAccrualPeriodRecordService.decrease(allocation.getVacationAccrualPeriodRecord().getId(), allocation.getDays()));
            addAccrualOnRecall(order);
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



    private Map<String,String> getCommonValues(VacationOrder order){
        Map<String, String> values = new HashMap<>();
        var employment = employeeUseCaseService.getCurrentEmployment(order.getVacation().getEmployee()).get();

        values.put("employeeName", employeeUseCaseService.getFullName(order.getVacation().getEmployee()));
        values.put("employeePosition", employment.position().name());

        return values;
    }


    private void addAccrualOnRecall(VacationOrder order){
        var request = vacationRequestService.getById(order.getVacation().getVacationRequest().getId());
        if (request.getVacationType().getCode().equals("RECALL")){
            var accrual = vacationAccrualService.getAllByEmployeeId(order.getVacation().getEmployee().getId()).getFirst();
            var period = accrual.getPeriods().stream()
                    .filter(p-> statusService.getById(p.getStatus().getId()).getCode().equals("ACTIVE"))
                    .sorted(Comparator.comparing(AbstractEntity::getId).reversed()).findFirst();
            vacationAccrualPeriodRecordService.create(
                    period.get().getId(),
                    new VacationAccrualPeriodRecordRequest(
                            vacationTypeService.getByCode("UNPAID").getId(),
                            order.getDate(),
                            request.getDays(),
                            0,
                            request.getDays(),
                            statusService.getByCode("ACTIVE").getId()
                    )
            );
        }
    }
}
