package com.fractal.domain.learning_develpment.learning.level.dto;

import java.time.LocalDateTime;

public record LearningLevelResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
