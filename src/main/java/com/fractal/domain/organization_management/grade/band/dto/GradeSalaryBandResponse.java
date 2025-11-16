package com.fractal.domain.organization_management.grade.band.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GradeSalaryBandResponse(
        Long id,
        BigDecimal minSalary,
        BigDecimal averageSalary,
        BigDecimal maxSalary,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
