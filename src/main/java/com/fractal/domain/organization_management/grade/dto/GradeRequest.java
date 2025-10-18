package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.organization_management.grade.band.GradeSalaryBand;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandRequest;
import com.fractal.domain.organization_management.grade.benchmarking.dto.BenchmarkingRequest;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
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
        List<BenchmarkingRequest> benchmarking,
        List<GradeMatrixRequest> matrices,
        List<GradeSalaryBandRequest> salaryBands,
        List<GradingEvaluationRequest> evaluations,
        List<GradeRequest> children
) {
}
