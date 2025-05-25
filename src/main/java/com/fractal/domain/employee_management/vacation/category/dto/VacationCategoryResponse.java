package com.fractal.domain.employee_management.vacation.category.dto;

import java.time.LocalDateTime;

public record VacationCategoryResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
