package com.fractal.domain.organization_management.grade.method.hay.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.dto.HayFactorCompactResponse;

import java.time.LocalDateTime;

public record HayEvaluationResponse(
        Long id,
        HayFactorCompactResponse hayFactor,
        Double point,
        StatusCompactResponse status,
        LocalDateTime createdDate

) implements GradingEvaluationResponse { }
