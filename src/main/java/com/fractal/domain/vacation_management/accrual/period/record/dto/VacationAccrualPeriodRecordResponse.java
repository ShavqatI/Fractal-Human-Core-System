package com.fractal.domain.vacation_management.accrual.period.record.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.vacation_management.category.dto.VacationCategoryResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VacationAccrualPeriodRecordResponse(
        Long id,
        VacationTypeResponse vacationType,
        LocalDate date,
        Integer accruedDays,
        Integer utilizedDays,
        Integer remainingDays,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
