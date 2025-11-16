package com.fractal.domain.organization_management.grade.matrix.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GradeMatrixResponse(
        Long id,
        BigDecimal minSalary,
        BigDecimal averageSalary,
        BigDecimal maxSalary,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
