package com.fractal.domain.employee_management.insurance.coverage.dto;

import java.math.BigDecimal;

public record InsuranceCoverageRequest(
        String description,
        BigDecimal amount

) {
}
