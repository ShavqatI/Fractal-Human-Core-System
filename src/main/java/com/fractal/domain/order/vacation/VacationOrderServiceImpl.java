package com.fractal.domain.order.vacation;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.order.vacation.mapper.VacationOrderMapperService;
import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
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
    private final StatusService statusService;
    private final OrderStateService stateService;
    private final VacationService vacationService;
    private final AuthenticatedService authenticatedService;

    @Override
    @Transactional
    public VacationOrder create(VacationOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
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
}
