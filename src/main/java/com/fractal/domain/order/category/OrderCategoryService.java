package com.fractal.domain.order.category;

import com.fractal.domain.order.category.dto.OrderCategoryRequest;
import com.fractal.domain.order.category.dto.OrderCategoryResponse;

import java.util.List;

public interface OrderCategoryService {

    OrderCategory create(OrderCategoryRequest dto);

    List<OrderCategory> getAll();

    OrderCategory getByCode(String code);

    OrderCategory getById(Long id);

    OrderCategory update(Long id, OrderCategoryRequest dto);

    void deleteById(Long id);

    OrderCategoryResponse toDTO(OrderCategory orderCategory);
}
