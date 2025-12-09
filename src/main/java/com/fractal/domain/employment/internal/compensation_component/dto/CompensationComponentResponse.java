package com.fractal.domain.employment.internal.compensation_component.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employment.payment_frequency.dto.PaymentFrequencyResponse;
import com.fractal.domain.employment.salary_classification.dto.SalaryClassificationCompactResponse;
import com.fractal.domain.finance.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.finance.currency.dto.CurrencyResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record CompensationComponentResponse(
        Long id,
        SalaryClassificationCompactResponse salaryClassification,
        PaymentFrequencyResponse paymentFrequency,
        LocalDate startDate,
        LocalDate endDate,
        CurrencyCompactResponse currency,
        BigDecimal grossAmount,
        BigDecimal netAmount,
        BigDecimal taxAmount,
        BigDecimal deductionAmount,
        Boolean taxable,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
