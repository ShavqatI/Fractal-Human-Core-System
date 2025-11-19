package com.fractal.domain.order.type.dto;

import com.fractal.domain.dictionary.docuemnt_template_manager.dto.DocumentTemplateManagerResponse;
import com.fractal.domain.order.category.dto.OrderCategoryResponse;

import java.time.LocalDateTime;

public record OrderTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        String series,
        DocumentTemplateManagerResponse documentTemplateManager,
        OrderCategoryResponse orderCategory,
        LocalDateTime createdDate
) {
}
