package com.fractal.domain.navigation.action.category.dto;

import java.time.LocalDateTime;

public record ActionCategoryResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
