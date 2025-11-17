package com.fractal.domain.order.vacation;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.domain.order.vacation.dto.VacationOrderRequest;
import com.fractal.domain.order.vacation.dto.VacationOrderResponse;
import com.fractal.domain.order.vacation.mapper.VacationOrderMapperService;
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



    @Override
    @Transactional
    public VacationOrder create(VacationOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
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
            //vacation.setReviewedUser();
            order.setStatus(statusService.getByCode("REVIEWED"));
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
            //vacation.setApprovedUser();
            order.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }
}
