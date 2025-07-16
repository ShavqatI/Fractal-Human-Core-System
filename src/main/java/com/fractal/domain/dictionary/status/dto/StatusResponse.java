package com.fractal.domain.dictionary.status.dto;

import com.fractal.domain.dictionary.status.category.dto.StatusCategoryResponse;

import java.time.LocalDateTime;

public record StatusResponse(
        Long id,
        String code,
        String name,
        StatusCategoryResponse statusCategory,
        String description,
        LocalDateTime createdDate
) {
}
