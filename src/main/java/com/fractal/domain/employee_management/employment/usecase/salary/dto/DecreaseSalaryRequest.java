package com.fractal.domain.employee_management.employment.usecase.salary.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DecreaseSalaryRequest(
        BigDecimal amount,
        LocalDate startDate,
        String reason
) {
}
