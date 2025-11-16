package com.fractal.domain.organization_management.grade.matrix;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixRequest;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixResponse;
import com.fractal.domain.organization_management.grade.matrix.mapper.GradeMatrixMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeMatrixServiceImpl implements GradeMatrixService {

    private final GradeMatrixRepository gradeMatrixRepository;
    private final GradeService gradeService;
    private final GradeMatrixMapperService mapperService;


    @Override
    @Transactional
    public GradeMatrix create(Long gradeId, GradeMatrixRequest dto) {
        var grade = gradeService.getById(gradeId);
        var matrix = mapperService.toEntity(dto);
        grade.addMatrix(matrix);
        gradeService.save(grade);
        return matrix;
    }


    @Override
    public List<GradeMatrix> getAllByGradeId(Long gradeId) {
        return gradeMatrixRepository.findAllByGradeId(gradeId);
    }

    @Override
    public GradeMatrix getById(Long gradeId, Long id) {
        return gradeMatrixRepository.findByGradeIdAndId(gradeId, id).orElseThrow(() -> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public GradeMatrix update(Long gradeId, Long id, GradeMatrixRequest dto) {
        var grade = gradeService.getById(gradeId);
        var matrix = grade.getMatrices()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
        matrix = gradeMatrixRepository.save(mapperService.toEntity(matrix, dto));
        gradeService.save(grade);
        return matrix;
    }

    @Override
    public void delete(Long gradeId, Long id) {
        var grade = gradeService.getById(gradeId);
        var matrix = grade.getMatrices()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Grade step with id: " + id + " not found"));
        grade.removeMatrix(matrix);
        gradeService.save(grade);
    }

    @Override
    public GradeMatrixResponse toDTO(GradeMatrix step) {
        return mapperService.toDTO(step);
    }
}
