package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyResponse;
import com.fractal.domain.dictionary.status.dto.StatusResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record GradeResponse(
        Long id,
        String code,
        String name,
        CurrencyResponse currency,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        StatusResponse statusId,
        String notes,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
