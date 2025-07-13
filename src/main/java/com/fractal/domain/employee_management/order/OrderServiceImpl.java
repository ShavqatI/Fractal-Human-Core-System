package com.fractal.domain.employee_management.order;

import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Order with id: " + id + " not found"));
    }

    @Override
    public void save(Order order) {
        try {
            orderRepository.save(order);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
