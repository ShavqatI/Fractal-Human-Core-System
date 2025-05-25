package com.fractal.domain.employee_management.performance.type.dto;

import java.time.LocalDateTime;

public record PerformanceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
