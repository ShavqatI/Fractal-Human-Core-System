package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.grade.level.dto.GradeLevelResponse;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record GradeResponse(
        Long id,
        String code,
        String name,
        CurrencyCompactResponse currency,
        GradeLevelResponse level,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        StatusCompactResponse status,
        String notes,
        List<GradeStepResponse> steps,
        List<GradeResponse> children,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
