package com.fractal.domain.organization_management.grade.benchmarking.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BenchmarkingResponse(
        Long id,
        BenchmarkingTypeResponse benchmarkingType,
        BigDecimal minSalary,
        BigDecimal averageSalary,
        BigDecimal maxSalary,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
