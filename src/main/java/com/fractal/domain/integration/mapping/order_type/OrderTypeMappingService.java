package com.fractal.domain.integration.mapping.order_type;

import com.fractal.domain.integration.mapping.order_type.dto.OrderTypeMappingRequest;
import com.fractal.domain.integration.mapping.order_type.dto.OrderTypeMappingResponse;

import java.util.List;

public interface OrderTypeMappingService {

    OrderTypeMapping create(OrderTypeMappingRequest dto);
    List<OrderTypeMapping> getAll();
    OrderTypeMapping getById(Long id);
    OrderTypeMapping update(Long id, OrderTypeMappingRequest dto);
    void deleteById(Long id);
    OrderTypeMappingResponse toDTO(OrderTypeMapping orderTypeMapping);
}
