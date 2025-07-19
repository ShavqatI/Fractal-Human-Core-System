package com.fractal.domain.employee_management.employment.order;

import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderRequest;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;
import com.fractal.domain.employee_management.employment.order.mapper.EmploymentHistoryOrderMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentHistoryOrderServiceImpl implements EmploymentHistoryOrderService {

    private final EmploymentHistoryOrderRepository orderRepository;
    private final EmploymentHistoryOrderMapperService orderMapperService;
    private final EmploymentHistoryService employmentHistoryService;


    @Override
    @Transactional
    public EmploymentHistoryOrder create(Long employeeId, EmploymentHistoryOrderRequest dto) {
        var employmentHistory = employmentHistoryService.getById(employeeId);
        var order = orderMapperService.toEntity(dto);
        employmentHistory.addOrder(order);
        employmentHistoryService.save(employmentHistory);
        return order;
    }

    @Override
    public List<EmploymentHistoryOrder> getAllByEmploymentHistoryId(Long employmentHistoryId) {
        return orderRepository.findAllByEmploymentHistoryId(employmentHistoryId);
    }

    @Override
    public EmploymentHistoryOrder getById(Long employmentHistoryId, Long id) {
        return orderRepository.findByEmploymentHistoryIdAndId(employmentHistoryId,id).orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmploymentHistoryOrder update(Long employmentHistoryId, Long id, EmploymentHistoryOrderRequest dto) {
        var employmentHistory = employmentHistoryService.getById(employmentHistoryId);
        var order = employmentHistory.getOrders()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        order = orderRepository.save(orderMapperService.toEntity(order,dto));
        employmentHistoryService.save(employmentHistory);
        return order;
    }

    @Override
    @Transactional
    public void delete(Long employmentHistoryId, Long id) {
        var employmentHistory = employmentHistoryService.getById(employmentHistoryId);
        var order = employmentHistory.getOrders()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        employmentHistory.removeOrder(order);
        orderRepository.delete(order);
        employmentHistoryService.save(employmentHistory);
    }

    @Override
    public EmploymentHistoryOrderResponse toDTO(EmploymentHistoryOrder order) {
        return orderMapperService.toDTO(order);
    }


}
