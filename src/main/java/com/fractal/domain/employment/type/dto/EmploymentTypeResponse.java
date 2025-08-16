package com.fractal.domain.employment.type.dto;

import java.time.LocalDateTime;

public record EmploymentTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
