package com.fractal.domain.vacation_management.accrual.period.dto;

import java.time.LocalDate;

public record PeriodRequest(
        LocalDate startDate,
        LocalDate endDate

) {
}
