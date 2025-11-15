package com.fractal.domain.vacation_management.category.dto;

import java.time.LocalDateTime;

public record VacationCategoryResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
