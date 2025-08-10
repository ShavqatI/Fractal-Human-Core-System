package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.organization_management.grade.step.dto.GradeStepRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record GradeRequest(
        String code,
        String name,
        Long currencyId,
        Long levelId,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        Long statusId,
        String notes,
        List<GradeStepRequest> steps,
        List<GradeRequest> children
) {
}
