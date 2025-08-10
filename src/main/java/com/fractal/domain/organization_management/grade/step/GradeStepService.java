package com.fractal.domain.organization_management.grade.step;

import com.fractal.domain.organization_management.grade.step.dto.GradeStepRequest;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepResponse;

import java.util.List;

public interface GradeStepService {

    GradeStep create(Long organizationId, GradeStepRequest dto);
    GradeStep getById(Long organizationId,Long id);
    List<GradeStep> getAllByGradeId(Long gradeId);
    GradeStep update(Long gradeId,Long id, GradeStepRequest dto);
    void delete(Long organizationId, Long id);
    GradeStepResponse toDTO(GradeStep step);
}
