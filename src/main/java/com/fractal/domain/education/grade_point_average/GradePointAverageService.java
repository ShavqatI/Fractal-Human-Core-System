package com.fractal.domain.education.grade_point_average;

import com.fractal.domain.education.grade_point_average.dto.GradePointAverageRequest;
import com.fractal.domain.education.grade_point_average.dto.GradePointAverageResponse;

import java.util.List;

public interface GradePointAverageService {

    GradePointAverage create(GradePointAverageRequest dto);
    List<GradePointAverage> getAll();
    GradePointAverage getById(Long id);
    GradePointAverage update(Long id, GradePointAverageRequest dto);
    void deleteById(Long id);
    GradePointAverageResponse toDTO(GradePointAverage gradePointAverage);
}
