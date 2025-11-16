package com.fractal.domain.organization_management.grade.method.hay.dto;

import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;

public record HayEvaluationRequest(
        Long hayFactorId,
        Double point,
        Long statusId

) implements GradingEvaluationRequest {
}
