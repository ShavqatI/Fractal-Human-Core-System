package com.fractal.domain.order.employment;

import com.fractal.domain.order.employment.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.order.employment.dto.InternalEmploymentOrderResponse;
import com.fractal.domain.order.employment.mapper.BusinessTripOrderMapperService;
import com.fractal.domain.order.state.OrderStateService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalEmploymentOrderServiceImpl implements InternalEmploymentOrderService {

    private final InternalEmploymentOrderRepository orderRepository;
    private final BusinessTripOrderMapperService orderMapperService;
    private final OrderStateService stateService;


    @Override
    @Transactional
    public InternalEmploymentOrder create(InternalEmploymentOrderRequest dto) {
        var order = orderMapperService.toEntity(dto);
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
        var order = orderRepository.save(orderMapperService.toEntity(getById(id), dto));
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


}
