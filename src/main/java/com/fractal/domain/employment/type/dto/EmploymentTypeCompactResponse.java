package com.fractal.domain.employment.type.dto;

import java.time.LocalDateTime;

public record EmploymentTypeCompactResponse(
        Long id,
        String code,
        String name
) {
}
