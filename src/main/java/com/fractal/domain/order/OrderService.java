package com.fractal.domain.order;

public interface OrderService {
    Order getById(Long id);

    void save(Order order);

}
