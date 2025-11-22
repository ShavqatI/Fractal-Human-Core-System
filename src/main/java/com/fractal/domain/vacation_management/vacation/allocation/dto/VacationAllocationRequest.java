package com.fractal.domain.vacation_management.vacation.allocation.dto;

public record VacationAllocationRequest(
        Long accrualPeriodRecordId,
        Integer days
) {
}
