package com.fractal.domain.education.degree_type.dto;

import java.time.LocalDateTime;

public record DegreeTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
