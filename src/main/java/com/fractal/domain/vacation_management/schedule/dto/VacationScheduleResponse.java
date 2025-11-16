package com.fractal.domain.vacation_management.schedule.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VacationScheduleResponse(
        Long id,
        EmployeeCompactResponse employee,
        VacationTypeResponse vacationType,
        LocalDate startDate,
        LocalDate endDate,
        Integer days,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
