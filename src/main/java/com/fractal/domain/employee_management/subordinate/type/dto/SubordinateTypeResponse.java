package com.fractal.domain.employee_management.subordinate.type.dto;

import java.time.LocalDateTime;

public record SubordinateTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
