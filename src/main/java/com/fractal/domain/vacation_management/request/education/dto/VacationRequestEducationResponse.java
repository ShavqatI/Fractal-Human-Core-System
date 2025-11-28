package com.fractal.domain.vacation_management.request.education.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record VacationRequestEducationResponse(
        Long id,
        LocalDate beginDate,
        LocalDate endDate,
        String institutionName,
        String institutionAddress,
        Boolean isForeignInstitution,
        String specialization,
        LocalDateTime createdDate
) {
}
