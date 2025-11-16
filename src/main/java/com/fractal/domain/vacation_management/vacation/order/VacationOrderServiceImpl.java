package com.fractal.domain.vacation_management.vacation.order;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderApprovalWorkflowAwareRequest;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderRequest;
import com.fractal.domain.vacation_management.vacation.order.dto.VacationOrderResponse;
import com.fractal.domain.vacation_management.vacation.order.mapper.VacationOrderMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationOrderServiceImpl implements VacationOrderService {

    private final VacationOrderRepository orderRepository;
    private final VacationOrderMapperService orderMapperService;
    private final VacationService vacationService;
    private final StatusService statusService;
    private final OrderStateService stateService;


    @Override
    @Transactional
    public VacationOrder create(Long vacationId, VacationOrderRequest dto) {
        var vacation = vacationService.getById(vacationId);
        var order = orderMapperService.toEntity(dto);
        vacation.addOrder(order);
        vacationService.save(vacation);
        return order;
    }

    @Override
    public List<VacationOrder> getAllByVacationId(Long vacationId) {
        return orderRepository.findAllByVacationId(vacationId);
    }

    @Override
    public VacationOrder getById(Long vacationId, Long id) {
        return orderRepository.findByVacationIdAndId(vacationId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public VacationOrder update(Long vacationId, Long id, VacationOrderRequest dto) {
        var vacation = vacationService.getById(vacationId);
        var order = vacation.getOrders()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order = orderRepository.save(orderMapperService.toEntity(order, dto));
        vacationService.save(vacation);
        return order;
    }

    @Override
    @Transactional
    public void delete(Long vacationId, Long id) {
        var vacation = vacationService.getById(vacationId);
        var order = vacation.getOrders()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        vacation.removeOrder(order);
        vacationService.save(vacation);
    }

    @Override
    public VacationOrderResponse toDTO(VacationOrder order) {
        return orderMapperService.toDTO(order);
    }


    @Override
    public VacationOrder review(VacationOrderApprovalWorkflowAwareRequest dto) {
        var order = getById(dto.vacationId(),dto.id());
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            //vacation.setReviewedUser();
            order.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public VacationOrder approve(VacationOrderApprovalWorkflowAwareRequest dto) {
        var order = getById(dto.vacationId(),dto.id());
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            //vacation.setApprovedUser();
            order.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }
}
