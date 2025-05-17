package com.fractal.domain.dictionary.status.category.dto;

import java.time.LocalDateTime;

public record StatusCategoryResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
