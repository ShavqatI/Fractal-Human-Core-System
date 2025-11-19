package com.fractal.domain.vacation_management.accrual.usecase;

import com.fractal.domain.vacation_management.accrual.period.dto.PeriodRequest;

public interface VacationAccrualUseCaseService {

    Integer getEmployeeAllRemainingDays(Long employeeId, PeriodRequest dto);
}
