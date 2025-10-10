package com.fractal.domain.learning_develpment.learning.session.expense.dto;

import com.fractal.domain.finance.currency.dto.CurrencyResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeCompactResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record LearningSessionExpenseResponse(
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
