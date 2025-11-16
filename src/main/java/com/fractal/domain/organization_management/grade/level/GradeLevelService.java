package com.fractal.domain.organization_management.grade.level;

import com.fractal.domain.organization_management.grade.level.dto.GradeLevelRequest;
import com.fractal.domain.organization_management.grade.level.dto.GradeLevelResponse;

import java.util.List;

public interface GradeLevelService {

    GradeLevel create(GradeLevelRequest dto);

    List<GradeLevel> getAll();

    GradeLevel getByCode(String code);

    GradeLevel getById(Long id);

    GradeLevel update(Long id, GradeLevelRequest dto);

    void deleteById(Long id);

    GradeLevelResponse toDTO(GradeLevel gradeLevel);
}
