package com.fractal.domain.finance.expense.type.dto;

import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryResponse;

import java.time.LocalDateTime;

public record ExpenseTypeResponse(
        Long id,
        String code,
        String name,
        ExpenseTypeCategoryResponse category,
        String description,
        LocalDateTime createdDate
) {
}
