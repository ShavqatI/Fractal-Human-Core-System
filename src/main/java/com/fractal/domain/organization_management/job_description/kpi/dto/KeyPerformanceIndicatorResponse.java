package com.fractal.domain.organization_management.job_description.kpi.dto;

import java.time.LocalDateTime;

public record KeyPerformanceIndicatorResponse(
        Long id,
        String name,
        String description,
        String measureUnit,
        double targetValue,
        String frequency,
        LocalDateTime createdDate
) {
}
