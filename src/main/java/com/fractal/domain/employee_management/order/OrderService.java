package com.fractal.domain.employee_management.order;

public interface OrderService {
    Order getById(Long id);
    void save(Order order);

}
