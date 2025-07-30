package com.fractal.domain.organization_management.grade.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GradeRequest(
        String code,
        String name,
        Long currencyId,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        Long statusId,
        String notes
) {
}
