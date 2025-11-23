package com.fractal.domain.order.business_trip;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.order.business_trip.mapper.BusinessTripOrderMapperService;
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
public class BusinessTripOrderServiceImpl implements BusinessTripOrderService {

    private final BusinessTripOrderRepository orderRepository;
    private final BusinessTripOrderMapperService orderMapperService;
    private final OrderStateService stateService;
    private final StatusService statusService;


    @Override
    @Transactional
    public BusinessTripOrder create(BusinessTripOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
        order.setStatus(statusService.getByCode("CREATED"));
        order = save(order);
        stateService.create(order);
        return order;
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
        var order = save(orderMapperService.toEntity(getById(id), dto));
        return order;
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
            return orderRepository.save(order);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public BusinessTripOrder review(Long id) {
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
    public BusinessTripOrder approve(Long id) {
        var order = getById(id);
        if (order.getStatus().getCode().equals("REVIEWED")) {
            order.setApprovedDate(LocalDateTime.now());
            //order.setApprovedUser(authenticatedService.getUser());
            order.setStatus(statusService.getByCode("APPROVED"));
            order.setStatus(order.getStatus());
            stateService.create(order);

            return order;
        } else {
            throw new ResourceStateException("The status is not valid is: " + order.getStatus().getName());
        }
    }
}
