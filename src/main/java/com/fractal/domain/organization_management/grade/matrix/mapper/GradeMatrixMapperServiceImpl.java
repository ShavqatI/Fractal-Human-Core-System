package com.fractal.domain.organization_management.grade.matrix.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.matrix.GradeMatrix;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixRequest;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GradeMatrixMapperServiceImpl implements GradeMatrixMapperService {


    private final StatusService statusService;


    @Override
    public GradeMatrixResponse toDTO(GradeMatrix matrix) {
        return new GradeMatrixResponse(
                matrix.getId(),
                matrix.getMinSalary(),
                matrix.getAverageSalary(),
                matrix.getMaxSalary(),
                statusService.toCompactDTO(matrix.getStatus()),
                matrix.getCreatedDate()

        );
    }

    @Override
    public GradeMatrix toEntity(GradeMatrixRequest dto) {
        return mapToEntity(new GradeMatrix(), dto);
    }

    @Override
    public GradeMatrix toEntity(GradeMatrix matrix, GradeMatrixRequest dto) {
        return mapToEntity(matrix, dto);
    }

    private GradeMatrix mapToEntity(GradeMatrix matrix, GradeMatrixRequest dto) {
        matrix.setStatus(statusService.getById(dto.statusId()));
        matrix.setMinSalary(dto.minSalary());
        matrix.setAverageSalary(dto.averageSalary());
        matrix.setMaxSalary(dto.maxSalary());
        return matrix;
    }

}
