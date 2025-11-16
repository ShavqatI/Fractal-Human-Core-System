package com.fractal.domain.order.state;

import com.fractal.domain.order.Order;
import com.fractal.domain.vacation_management.request.VacationRequest;

import java.util.List;

public interface OrderStateService {
    OrderState create(Order order);

    List<OrderState> getAll();

    OrderState getById(Long id);

    List<OrderState> getAllByOrderId(Long orderId);

    OrderState update(Long id, Order order);

    void deleteById(Long id);

    OrderStateResponse toDTO(OrderState state);

    OrderState save(OrderState state);
}
