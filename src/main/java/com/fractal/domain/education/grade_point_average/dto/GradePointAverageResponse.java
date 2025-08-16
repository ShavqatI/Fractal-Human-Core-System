package com.fractal.domain.education.grade_point_average.dto;

import java.time.LocalDateTime;

public record GradePointAverageResponse(
        Long id,
        String value,
        Double scale,
        LocalDateTime createdDate
) {
}
