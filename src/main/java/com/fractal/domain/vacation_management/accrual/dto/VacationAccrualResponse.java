package com.fractal.domain.vacation_management.accrual.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.vacation_management.accrual.period.dto.VacationAccrualPeriodResponse;

import java.time.LocalDateTime;
import java.util.List;

public record VacationAccrualResponse(
        Long id,
        EmployeeCompactResponse employee,
        List<VacationAccrualPeriodResponse> periods,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
