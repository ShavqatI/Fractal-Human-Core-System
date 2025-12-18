package com.fractal.domain.employee_management.attendance.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AttendanceRequest(
        Long employeeId,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        String remarks

) {
}
