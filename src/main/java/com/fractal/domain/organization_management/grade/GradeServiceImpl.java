package com.fractal.domain.organization_management.grade;

import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;
import com.fractal.domain.organization_management.grade.mapper.GradeMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

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
        return gradeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Grade with code: " + code + " not found"));
    }

    @Override
    public Grade getById(Long id) {
        return findById(id);
    }

    @Override
    public Grade update(Long id, GradeRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id),dto));
        }
        catch (DataAccessException e) {
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

    private Grade save(Grade grade) {
        try {
            return gradeRepository.save(grade);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Grade findById(Long id) {
        return gradeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grade with id: " + id + " not found"));
    }
}
