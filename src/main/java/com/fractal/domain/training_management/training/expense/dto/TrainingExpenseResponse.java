package com.fractal.domain.training_management.training.expense.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record TrainingExpenseResponse(
        Long id,
        ExpenseTypeCompactResponse expenseType,
        LocalDate date,
        CurrencyResponse currency,
        BigDecimal amount,
        String description,
        String invoiceNumber,
        List<ResourceResponse> resources,
        StatusCompactResponse status,
        LocalDateTime createdDate

)
{ }
