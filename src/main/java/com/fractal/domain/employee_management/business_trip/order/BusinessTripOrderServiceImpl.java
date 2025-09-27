package com.fractal.domain.employee_management.business_trip.order;

import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderRequest;
import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;
import com.fractal.domain.employee_management.business_trip.order.mapper.BusinessTripOrderMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripOrderServiceImpl implements BusinessTripOrderService {

    private final BusinessTripOrderRepository orderRepository;
    private final BusinessTripOrderMapperService orderMapperService;
    private final BusinessTripService businessTripService;


    @Override
    @Transactional
    public BusinessTripOrder create(Long businessTripId, BusinessTripOrderRequest dto) {
        var businessTrip = businessTripService.getById(businessTripId);
        var order = orderMapperService.toEntity(dto);
        businessTrip.addOrder(order);
        businessTripService.save(businessTrip);
        return order;
    }

    @Override
    public List<BusinessTripOrder> getAllByBusinessTripId(Long businessTripId) {
        return orderRepository.findAllByBusinessTripId(businessTripId);
    }

    @Override
    public BusinessTripOrder getById(Long businessTripId, Long id) {
        return orderRepository.findByBusinessTripIdAndId(businessTripId,id).orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public BusinessTripOrder update(Long businessTripId, Long id, BusinessTripOrderRequest dto) {
        var businessTrip = businessTripService.getById(businessTripId);
        var order = businessTrip.getOrders()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order = orderRepository.save(orderMapperService.toEntity(order,dto));
        businessTripService.save(businessTrip);
        return order;
    }

    @Override
    @Transactional
    public void delete(Long businessTripId, Long id) {
        var businessTrip = businessTripService.getById(businessTripId);
        var order = businessTrip.getOrders()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        businessTrip.removeOrder(order);
        businessTripService.save(businessTrip);
    }

    @Override
    public BusinessTripOrderResponse toDTO(BusinessTripOrder order) {
        return orderMapperService.toDTO(order);
    }


}
