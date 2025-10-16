package com.fractal.domain.organization_management.grade.benchmarking.type.dto;

import java.time.LocalDateTime;

public record BenchmarkingTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
