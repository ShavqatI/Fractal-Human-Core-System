package com.fractal.domain.organization_management.grade.matrix.dto;

import java.math.BigDecimal;

public record GradeMatrixRequest(
        BigDecimal minSalary,
        BigDecimal averageSalary,
        BigDecimal maxSalary,
        Long statusId
) {
}
