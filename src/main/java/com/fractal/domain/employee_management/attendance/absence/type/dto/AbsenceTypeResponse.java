package com.fractal.domain.employee_management.attendance.absence.type.dto;

import java.time.LocalDateTime;

public record AbsenceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
