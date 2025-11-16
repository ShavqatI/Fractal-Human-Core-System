package com.fractal.domain.vacation_management.accrual.period.dto;

import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;

import java.time.LocalDate;
import java.util.List;

public record VacationAccrualPeriodRequest(
        LocalDate startDate,
        LocalDate endDate,
        List<VacationAccrualPeriodRecordRequest> records
) {
}
