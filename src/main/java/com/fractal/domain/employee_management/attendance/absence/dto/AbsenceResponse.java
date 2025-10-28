package com.fractal.domain.employee_management.attendance.absence.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AbsenceResponse(
        Long id,
        EmployeeCompactResponse employee,
        AbsenceTypeResponse absenceType,
        StatusCompactResponse status,
        LocalDate startDate,
        LocalDate endDate,
        int duration,
        String reason,
        String remarks,
        LocalDateTime createdDate
)
{ }
