package com.fractal.domain.organization_management.grade.method.mapper;

import com.fractal.domain.organization_management.grade.method.GradingEvaluation;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;

public interface GradingEvaluationMapperService {
    GradingEvaluationResponse toDTO(GradingEvaluation gradingEvaluation);
    GradingEvaluation toEntity(GradingEvaluationRequest dto);
}


