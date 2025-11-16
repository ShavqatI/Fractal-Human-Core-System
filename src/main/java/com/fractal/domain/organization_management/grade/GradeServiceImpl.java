package com.fractal.domain.organization_management.grade;

import com.fractal.domain.organization_management.grade.dto.GradeCompactResponse;
import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;
import com.fractal.domain.organization_management.grade.mapper.GradeMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final GradeMapperService mapperService;

    @Override
    public Grade create(GradeRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getByCode(String code) {
        return gradeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Grade with code: " + code + " not found"));
    }

    @Override
    public Grade getById(Long id) {
        return findById(id);
    }

    @Override
    public Grade update(Long id, GradeRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        gradeRepository.delete(findById(id));
    }

    @Override
    public GradeResponse toDTO(Grade grade) {
        return mapperService.toDTO(grade);
    }

    @Override
    public GradeCompactResponse toCompactDTO(Grade grade) {
        return mapperService.toCompactDTO(grade);
    }


    @Override
    @Transactional
    public Grade addChild(Long id, GradeRequest dto) {
        var grade = findById(id);
        var child = mapperService.toEntity(dto);
        grade.addChild(child);
        return save(grade);
    }

    @Override
    @Transactional
    public Grade updateChild(Long id, Long childId, GradeRequest dto) {
        var grade = findById(id);
        var child = grade.getChildren().stream().filter(ch -> ch.getId().equals(childId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Child with id: " + childId + " not found"));
        update(child.getId(), dto);
        return save(grade);
    }

    @Override
    @Transactional
    public Grade deleteChild(Long id, Long childId) {
        var grade = findById(id);
        var child = grade.getChildren().stream().filter(ch -> ch.getId().equals(childId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Child with id: " + childId + " not found"));
        grade.removeChild(child);
        return save(grade);
    }

    @Override
    public Grade save(Grade grade) {
        try {
            return gradeRepository.save(grade);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Grade findById(Long id) {
        return gradeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Grade with id: " + id + " not found"));
    }
}
