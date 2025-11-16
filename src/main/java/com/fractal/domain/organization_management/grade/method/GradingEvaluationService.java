package com.fractal.domain.organization_management.grade.method;

public interface GradingEvaluationService {
    GradingEvaluation getById(Long id);

    GradingEvaluation save(GradingEvaluation gradingEvaluation);
}
