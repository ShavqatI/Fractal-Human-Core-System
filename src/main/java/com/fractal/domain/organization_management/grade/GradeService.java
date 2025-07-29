package com.fractal.domain.organization_management.grade;

import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;

import java.util.List;

public interface GradeService {
    Grade create(GradeRequest dto);
    List<Grade> getAll();
    Grade getByCode(String code);
    Grade getById(Long id);
    Grade update(Long id, GradeRequest dto);
    void deleteById(Long id);
    GradeResponse toDTO(Grade grade);


}
