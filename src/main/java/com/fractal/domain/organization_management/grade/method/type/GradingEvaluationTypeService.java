package com.fractal.domain.organization_management.grade.method.type;

import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeCompactResponse;
import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeRequest;
import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeResponse;

import java.util.List;

public interface GradingEvaluationTypeService {

    GradingEvaluationType create(GradingEvaluationTypeRequest dto);
    List<GradingEvaluationType> getAll();
    GradingEvaluationType getByCode(String code);
    GradingEvaluationType getById(Long id);
    GradingEvaluationType update(Long id, GradingEvaluationTypeRequest dto);
    void deleteById(Long id);
    GradingEvaluationTypeResponse toDTO(GradingEvaluationType gradingEvaluationType);
    GradingEvaluationTypeCompactResponse toCompactDTO(GradingEvaluationType gradingEvaluationType);
}
