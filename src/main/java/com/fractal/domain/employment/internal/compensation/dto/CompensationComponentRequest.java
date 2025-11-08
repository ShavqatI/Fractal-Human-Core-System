package com.fractal.domain.employment.internal.compensation.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
