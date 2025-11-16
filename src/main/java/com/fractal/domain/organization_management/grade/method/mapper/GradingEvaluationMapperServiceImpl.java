package com.fractal.domain.organization_management.grade.method.mapper;

import com.fractal.domain.organization_management.grade.method.GradingEvaluation;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;
import com.fractal.domain.organization_management.grade.method.hay.HayEvaluation;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.hay.mapper.HayEvaluationMapperService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GradingEvaluationMapperServiceImpl implements GradingEvaluationMapperService {

    private final HayEvaluationMapperService hayEvaluationMapperService;

    @Override
    public GradingEvaluationResponse toDTO(GradingEvaluation gradingEvaluation) {
        gradingEvaluation = (GradingEvaluation) Hibernate.unproxy(gradingEvaluation);
        if (gradingEvaluation instanceof HayEvaluation)
            return hayEvaluationMapperService.toDTO((HayEvaluation) gradingEvaluation);
        return null;
    }

    @Override
    public GradingEvaluation toEntity(GradingEvaluationRequest dto) {
        if (dto instanceof HayEvaluationRequest)
            return hayEvaluationMapperService.toEntity((HayEvaluationRequest) dto);
        return null;
    }
}
