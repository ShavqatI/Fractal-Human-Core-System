package com.fractal.domain.finance.expense.type.dto;

public record ExpenseTypeCompactResponse(
        Long id,
        String code,
        String name
) {
}
