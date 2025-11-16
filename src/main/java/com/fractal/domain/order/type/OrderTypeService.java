package com.fractal.domain.order.type;

import com.fractal.domain.order.type.dto.OrderTypeRequest;
import com.fractal.domain.order.type.dto.OrderTypeResponse;

import java.util.List;

public interface OrderTypeService {

    OrderType create(OrderTypeRequest dto);

    List<OrderType> getAll();

    OrderType getByCode(String code);

    OrderType getById(Long id);

    OrderType update(Long id, OrderTypeRequest dto);

    void deleteById(Long id);

    OrderTypeResponse toDTO(OrderType orderType);
}
