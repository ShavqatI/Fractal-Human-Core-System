package com.fractal.domain.organization_management.grade.matrix;

import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixRequest;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixResponse;

import java.util.List;

public interface GradeMatrixService {

    GradeMatrix create(Long organizationId, GradeMatrixRequest dto);

    GradeMatrix getById(Long organizationId, Long id);

    List<GradeMatrix> getAllByGradeId(Long gradeId);

    GradeMatrix update(Long gradeId, Long id, GradeMatrixRequest dto);

    void delete(Long organizationId, Long id);

    GradeMatrixResponse toDTO(GradeMatrix step);
}
