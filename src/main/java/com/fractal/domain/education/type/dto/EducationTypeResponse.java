package com.fractal.domain.education.type.dto;

import java.time.LocalDateTime;

public record EducationTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
