package com.fractal.domain.employee_management.employment.agreement.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgreementResponse(
        Long id,
        String number,
        LocalDate startDate,
        LocalDate endDate,
        String status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
