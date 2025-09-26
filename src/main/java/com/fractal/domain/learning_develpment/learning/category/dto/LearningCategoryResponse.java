package com.fractal.domain.learning_develpment.learning.category.dto;

import java.time.LocalDateTime;
import java.util.List;

public record LearningCategoryResponse(
        Long id,
        String code,
        String name,
        String description,
        List<LearningCategoryResponse> children,
        LocalDateTime createdDate

) {

}
