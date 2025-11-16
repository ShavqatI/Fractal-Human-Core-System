package com.fractal.domain.employee_management.attendance.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record AttendanceResponse(
        Long id,
        EmployeeCompactResponse employee,
        LocalDate date,
        StatusCompactResponse status,
        LocalTime startTime,
        LocalTime endTime,
        long hoursWorked,
        long overtimeHours,
        String remarks,
        LocalDateTime createdDate
) {
}
