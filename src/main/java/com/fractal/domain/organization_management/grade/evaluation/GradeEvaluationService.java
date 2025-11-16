package com.fractal.domain.organization_management.grade.evaluation;

import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;

import java.util.List;

public interface GradeEvaluationService {
    GradeEvaluation create(Long gradeId, GradingEvaluationRequest dto);

    GradeEvaluation getById(Long gradeId, Long id);

    List<GradeEvaluation> getAllByGradeId(Long gradeId);

    GradeEvaluation update(Long gradeId, Long id, GradingEvaluationRequest dto);

    void delete(Long gradeId, Long id);

    GradingEvaluationResponse toDTO(GradeEvaluation evaluation);

}
