package com.fractal.domain.learning_develpment.learning.type.dto;

import java.time.LocalDateTime;

public record LearningTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
