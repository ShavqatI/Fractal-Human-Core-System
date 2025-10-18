package com.fractal.domain.organization_management.grade.method.type.dto;

import java.time.LocalDateTime;

public record GradingEvaluationTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
