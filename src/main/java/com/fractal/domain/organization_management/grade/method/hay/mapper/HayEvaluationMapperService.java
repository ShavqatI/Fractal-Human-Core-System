package com.fractal.domain.organization_management.grade.method.hay.mapper;

import com.fractal.domain.organization_management.grade.method.hay.HayEvaluation;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationResponse;

public interface HayEvaluationMapperService {
    HayEvaluationResponse toDTO(HayEvaluation hayEvaluation);

    HayEvaluation toEntity(HayEvaluationRequest dto);

    HayEvaluation toEntity(HayEvaluation hayEvaluation, HayEvaluationRequest dto);
}


