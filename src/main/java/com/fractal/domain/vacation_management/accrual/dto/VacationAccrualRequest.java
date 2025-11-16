package com.fractal.domain.vacation_management.accrual.dto;

import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodRequest;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VacationAccrualRequest(
        @NotNull
        Long employeeId,
        List<VacationAccrualPeriodRequest> periods,
        Long statusId

) {
}