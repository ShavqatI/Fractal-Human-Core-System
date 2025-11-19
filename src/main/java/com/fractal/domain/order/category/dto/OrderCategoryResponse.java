package com.fractal.domain.order.category.dto;

import java.time.LocalDateTime;

public record OrderCategoryResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
