package com.fractal.domain.employee_management.business_trip.expense.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.employee_management.business_trip.expense.type.BusinessTripExpenseType;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeResponse;
import com.fractal.domain.employee_management.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripExpenseResponse(
        Long id,
        BusinessTripExpenseTypeResponse businessTripExpenseType,
        CurrencyCompactResponse currency,
        BigDecimal amount,
        String description,
        LocalDate date,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
