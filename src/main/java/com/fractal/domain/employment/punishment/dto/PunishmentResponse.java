package com.fractal.domain.employment.punishment.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PunishmentResponse(
        Long id,
        PunishmentTypeResponse punishmentType,
        String description,
        BigDecimal amount,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime canceledDate,
        String canceledReason,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
