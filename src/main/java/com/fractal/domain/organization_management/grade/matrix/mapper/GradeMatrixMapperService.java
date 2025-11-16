package com.fractal.domain.organization_management.grade.matrix.mapper;

import com.fractal.domain.organization_management.grade.matrix.GradeMatrix;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixRequest;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixResponse;

public interface GradeMatrixMapperService {
    GradeMatrixResponse toDTO(GradeMatrix matrix);

    GradeMatrix toEntity(GradeMatrixRequest dto);

    GradeMatrix toEntity(GradeMatrix matrix, GradeMatrixRequest dto);

}


