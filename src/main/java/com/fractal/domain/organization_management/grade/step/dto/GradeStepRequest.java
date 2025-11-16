package com.fractal.domain.organization_management.grade.step.dto;

import java.math.BigDecimal;

public record GradeStepRequest(

        BigDecimal minSalary,

        BigDecimal maxSalary,

        Long statusId
) {
}
