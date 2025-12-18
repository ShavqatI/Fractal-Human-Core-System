package com.fractal.domain.employee_management.attendance.dto;

import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCompactRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;

import java.time.LocalDate;
import java.time.LocalTime;

public record AttendanceBatchRequest(
        Long employeeId,
        AbsenceCompactRequest absence,
        LocalDate date
) {}
