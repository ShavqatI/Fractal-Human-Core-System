package com.fractal.domain.employee_management.insurance.coverage.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InsuranceCoverageResponse(
        Long id,
        String description,
        BigDecimal amount,
        LocalDateTime createdDate

) {
}
