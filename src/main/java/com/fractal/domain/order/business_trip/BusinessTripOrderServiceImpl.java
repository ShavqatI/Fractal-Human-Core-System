package com.fractal.domain.order.business_trip;

import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderRequest;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.order.business_trip.mapper.BusinessTripOrderMapperService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripOrderServiceImpl implements BusinessTripOrderService {

    private final BusinessTripOrderRepository orderRepository;
    private final BusinessTripOrderMapperService orderMapperService;
    private final OrderStateService stateService;


    @Override
    @Transactional
    public BusinessTripOrder create(BusinessTripOrderRequest dto) {
        var order = save(orderMapperService.toEntity(dto));
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


}
