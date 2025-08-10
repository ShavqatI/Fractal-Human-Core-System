package com.fractal.domain.organization_management.grade.level;

import com.fractal.domain.organization_management.grade.level.dto.GradeLevelRequest;
import com.fractal.domain.organization_management.grade.level.dto.GradeLevelResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class GradeLevelServiceImpl implements GradeLevelService {

    private final GradeLevelRepository gradeLevelRepository;

    @Override
    public GradeLevel create(GradeLevelRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<GradeLevel> getAll() {
        return gradeLevelRepository.findAll();
    }

    @Override
    public GradeLevel getByCode(String code) {
        return gradeLevelRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Gender with code: " + code + " not found"));
    }

    @Override
    public GradeLevel getById(Long id) {
        return findById(id);
    }

    @Override
    public GradeLevel update(Long id, GradeLevelRequest dto) {
        try {
            GradeLevel gradeLevel = findById(id);
            gradeLevel.setCode(dto.code());
            gradeLevel.setName(dto.name());
            return save(gradeLevel);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        gradeLevelRepository.delete(findById(id));
    }

    @Override
    public GradeLevelResponse toDTO(GradeLevel gradeLevel) {
        return new GradeLevelResponse(
                gradeLevel.getId(),
                gradeLevel.getCode(),
                gradeLevel.getName(),
                gradeLevel.getCreatedDate()
        );
    }

    private GradeLevel toEntity(GradeLevelRequest dto) {
        return GradeLevel.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private GradeLevel save(GradeLevel gradeLevel) {
        try {
            return gradeLevelRepository.save(gradeLevel);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private GradeLevel findById(Long id) {
        return gradeLevelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gender with id: " + id + " not found"));
    }
}
