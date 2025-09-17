package com.fractal.domain.employee_management.insurance.coverage.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InsuranceCoverageResponse(
        Long id,
        String description,
        BigDecimal amount,
        LocalDateTime createdDate

) {
}
