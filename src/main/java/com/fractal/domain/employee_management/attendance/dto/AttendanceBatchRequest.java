package com.fractal.domain.employee_management.attendance.dto;

import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCompactRequest;

import java.time.LocalDate;

public record AttendanceBatchRequest(
        Long employeeId,
        AbsenceCompactRequest absence,
        LocalDate date
) {}
