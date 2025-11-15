package com.fractal.domain.vacation_management.type.dto;

import java.time.LocalDateTime;

public record VacationTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        Integer days,
        LocalDateTime createdDate
) {
}
