package com.fractal.domain.organization_management.grade.method.hay;

import com.fractal.domain.organization_management.grade.method.GradingEvaluationService;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.hay.dto.HayEvaluationResponse;

import java.util.List;

public interface HayEvaluationService extends GradingEvaluationService {
    HayEvaluation create(HayEvaluationRequest dto);
    List<HayEvaluation> getAll();
    HayEvaluation getById(Long id);
    HayEvaluation update(Long id, HayEvaluationRequest dto);
    void deleteById(Long id);
    HayEvaluationResponse toDTO(HayEvaluation hayEvaluation);
    HayEvaluation save(HayEvaluation hayEvaluation);

}
