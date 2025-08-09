package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.dictionary.currency.dto.CurrencyResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record GradeResponse(
        Long id,
        String code,
        String name,
        CurrencyCompactResponse currency,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        StatusCompactResponse status,
        String notes,
        List<GradeResponse> children,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
