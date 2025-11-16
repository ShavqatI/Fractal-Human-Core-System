package com.fractal.domain.vacation_management.accrual.period.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordRequest;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VacationAccrualPeriodResponse(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        List<VacationAccrualPeriodRecordResponse> records,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
