package com.fractal.domain.vacation_management.vacation.allocation.dto;

import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecord;
import com.fractal.domain.vacation_management.accrual.period.record.dto.VacationAccrualPeriodRecordResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDateTime;

public record VacationAllocationResponse(
        Long id,
        VacationAccrualPeriodRecordResponse accrualPeriodRecord,
        Integer days,
        LocalDateTime createdDate

) {
}
