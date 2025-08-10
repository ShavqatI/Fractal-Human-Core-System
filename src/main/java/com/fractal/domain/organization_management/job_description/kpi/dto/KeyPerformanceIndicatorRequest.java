package com.fractal.domain.organization_management.job_description.kpi.dto;

public record KeyPerformanceIndicatorRequest(
        String name,
        String description,
        String measureUnit,
        double targetValue,
        String frequency
) {
}
