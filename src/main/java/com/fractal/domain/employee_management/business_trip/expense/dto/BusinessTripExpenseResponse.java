package com.fractal.domain.employee_management.business_trip.expense.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.finance.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripExpenseResponse(
        Long id,
        ExpenseTypeCompactResponse expenseType,
        CurrencyCompactResponse currency,
        BigDecimal amount,
        String description,
        LocalDate date,
        List<ResourceResponse> resources,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
