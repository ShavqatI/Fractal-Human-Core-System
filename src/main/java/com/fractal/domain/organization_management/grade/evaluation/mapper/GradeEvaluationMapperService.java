package com.fractal.domain.organization_management.grade.evaluation.mapper;

import com.fractal.domain.organization_management.grade.evaluation.GradeEvaluation;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;

public interface GradeEvaluationMapperService {
    GradingEvaluationResponse toDTO(GradeEvaluation gradeEvaluation);

    GradeEvaluation toEntity(GradingEvaluationRequest dto);

    GradeEvaluation toEntity(GradeEvaluation gradeEvaluation, GradingEvaluationRequest dto);
}


