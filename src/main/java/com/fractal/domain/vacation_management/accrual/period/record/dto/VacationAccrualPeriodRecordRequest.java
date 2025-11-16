package com.fractal.domain.vacation_management.accrual.period.record.dto;

import java.time.LocalDate;

public record VacationAccrualPeriodRecordRequest(
        Long vacationTypeId,
        LocalDate date,
        Integer accruedDays,
        Integer utilizedDays,
        Integer remainingDays,
        Long statusId
) {}
