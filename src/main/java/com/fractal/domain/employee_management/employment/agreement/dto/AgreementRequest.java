package com.fractal.domain.employee_management.employment.agreement.dto;

import java.time.LocalDate;

public record AgreementRequest(
        String number,
        LocalDate startDate,
        LocalDate endDate,
        Long statusId
) {
}
