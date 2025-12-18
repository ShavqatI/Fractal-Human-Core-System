package com.fractal.domain.employee_management.attendance.absence.dto;

import java.time.LocalDate;

public record AbsenceCompactRequest(
        Long employeeId,
        LocalDate date,
        String reason

) {
}
