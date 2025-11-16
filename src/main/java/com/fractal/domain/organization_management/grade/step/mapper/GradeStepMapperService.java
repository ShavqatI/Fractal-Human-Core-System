package com.fractal.domain.organization_management.grade.step.mapper;

import com.fractal.domain.organization_management.grade.step.GradeStep;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepRequest;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepResponse;

public interface GradeStepMapperService {
    GradeStepResponse toDTO(GradeStep step);

    GradeStep toEntity(GradeStepRequest dto);

    GradeStep toEntity(GradeStep step, GradeStepRequest dto);
}


