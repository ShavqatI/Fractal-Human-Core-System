package com.fractal.domain.employee_management.vacation.type.dto;

import java.time.LocalDateTime;

public record VacationTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
