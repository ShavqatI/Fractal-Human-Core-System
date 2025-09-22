package com.fractal.domain.finance.expense.type.category.dto;

import java.time.LocalDateTime;

public record ExpenseTypeCategoryResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
