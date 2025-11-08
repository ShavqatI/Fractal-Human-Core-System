package com.fractal.domain.employment.internal.compensation.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CompensationComponentRequest(
        Long salaryClassificationId,
        Long paymentFrequencyId,
        LocalDate startDate,
        LocalDate endDate,
        Long currencyId,
        BigDecimal grossAmount,
        BigDecimal netAmount,
        BigDecimal taxAmount,
        BigDecimal deductionAmount,
        Boolean taxable,
        Long statusId
) {
}
