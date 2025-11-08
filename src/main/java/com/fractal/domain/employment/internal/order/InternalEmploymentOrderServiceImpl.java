package com.fractal.domain.employment.internal.order;

import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderRequest;
import com.fractal.domain.employment.internal.order.dto.InternalEmploymentOrderResponse;
import com.fractal.domain.employment.internal.order.mapper.InternalEmploymentOrderMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InternalEmploymentOrderServiceImpl implements InternalEmploymentOrderService {

    private final InternalEmploymentOrderRepository orderRepository;
    private final InternalEmploymentOrderMapperService orderMapperService;
    private final InternalEmploymentService employmentService;


    @Override
    @Transactional
    public InternalEmploymentOrder create(Long employmentId, InternalEmploymentOrderRequest dto) {
        var employment = employmentService.getById(employmentId);
        var order = orderMapperService.toEntity(dto);
        employment.addOrder(order);
        employmentService.save(employment);
        return order;
    }

    @Override
    public List<InternalEmploymentOrder> getAllByInternalEmploymentId(Long employmentId) {
        return orderRepository.findAllByInternalEmploymentId(employmentId);
    }

    @Override
    public InternalEmploymentOrder getById(Long employmentId, Long id) {
        return orderRepository.findByInternalEmploymentIdAndId(employmentId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    @Transactional
    public InternalEmploymentOrder update(Long employmentId, Long id, InternalEmploymentOrderRequest dto) {
        var employment = employmentService.getById(employmentId);
        var order = employment.getOrders()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        order = orderRepository.save(orderMapperService.toEntity(order,dto));
        employmentService.save(employment);
        return order;
    }

    @Override
    @Transactional
    public void delete(Long employmentId, Long id) {
        var employment = employmentService.getById(employmentId);
        var order = employment.getOrders()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        employment.removeOrder(order);
        employmentService.save(employment);
    }

    @Override
    public InternalEmploymentOrderResponse toDTO(InternalEmploymentOrder order) {
        return orderMapperService.toDTO(order);
    }


}
