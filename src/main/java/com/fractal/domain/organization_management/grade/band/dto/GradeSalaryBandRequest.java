package com.fractal.domain.organization_management.grade.band.dto;

import java.math.BigDecimal;

public record GradeSalaryBandRequest(
        BigDecimal minSalary,
        BigDecimal averageSalary,
        BigDecimal maxSalary,
        Long statusId
) {
}
