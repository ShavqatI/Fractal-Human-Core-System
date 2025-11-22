package com.fractal.domain.order.employment;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderResponse;
import com.fractal.domain.order.employment.mapper.InternalEmploymentOrderMapperService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalEmploymentOrderServiceImpl implements InternalEmploymentOrderService {

    private final InternalEmploymentOrderRepository orderRepository;
    private final InternalEmploymentOrderMapperService orderMapperService;
    private final OrderStateService stateService;
    private final StatusService statusService;


    @Override
    @Transactional
    public InternalEmploymentOrder create(InternalEmploymentOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
        order.setStatus(statusService.getByCode("CREATED"));
        order = save(order);
        stateService.create(order);
        return order;
    }

    @Override
    public List<InternalEmploymentOrder> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public InternalEmploymentOrder getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public InternalEmploymentOrder update(Long id, InternalEmploymentOrderRequest dto) {
        var order = save(orderMapperService.toEntity(getById(id), dto));
        return order;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(getById(id));
    }

    @Override
    public InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder order) {
        return orderMapperService.toDTO(order);
    }

    @Override
    @Transactional
    public InternalEmploymentOrder save(InternalEmploymentOrder order) {
        try {
            return orderRepository.save(order);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public InternalEmploymentOrder review(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("CREATED")) {
            order.setReviewedDate(LocalDateTime.now());
            //order.setReviewedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(order);
            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }

    @Override
    public InternalEmploymentOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            //order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(order);

            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }
}
