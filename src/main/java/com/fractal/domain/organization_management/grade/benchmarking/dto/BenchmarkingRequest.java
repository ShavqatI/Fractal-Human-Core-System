package com.fractal.domain.organization_management.grade.benchmarking.dto;

import java.math.BigDecimal;

public record BenchmarkingRequest(
        Long benchmarkingTypeId,
        BigDecimal minSalary,
        BigDecimal averageSalary,
        BigDecimal maxSalary,
        Long statusId
) {
}
