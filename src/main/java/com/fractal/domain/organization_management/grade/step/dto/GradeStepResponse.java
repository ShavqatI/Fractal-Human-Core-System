package com.fractal.domain.organization_management.grade.step.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GradeStepResponse(
        Long id,
        BigDecimal minSalary,

        BigDecimal maxSalary,

        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
