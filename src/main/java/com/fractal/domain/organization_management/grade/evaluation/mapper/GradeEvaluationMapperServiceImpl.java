package com.fractal.domain.organization_management.grade.evaluation.mapper;

import com.fractal.domain.organization_management.grade.evaluation.GradeEvaluation;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;
import com.fractal.domain.organization_management.grade.method.mapper.GradingEvaluationMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GradeEvaluationMapperServiceImpl implements GradeEvaluationMapperService {

    private final GradingEvaluationMapperService gradingEvaluationMapperService;

    @Override
    public GradingEvaluationResponse toDTO(GradeEvaluation gradeEvaluation) {
        return gradingEvaluationMapperService.toDTO(gradeEvaluation.getEvaluation());
    }

    @Override
    public GradeEvaluation toEntity(GradingEvaluationRequest dto) {
        return mapToEntity(new GradeEvaluation(), dto);
    }

    @Override
    public GradeEvaluation toEntity(GradeEvaluation evaluation, GradingEvaluationRequest dto) {
        return mapToEntity(evaluation, dto);
    }

    private GradeEvaluation mapToEntity(GradeEvaluation evaluation, GradingEvaluationRequest dto) {
        evaluation.setEvaluation(gradingEvaluationMapperService.toEntity(dto));
        return evaluation;
    }


}
