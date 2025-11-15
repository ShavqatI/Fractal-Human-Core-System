package com.fractal.domain.vacation_management.request.responsibility.dto;

import java.time.LocalDateTime;

public record VacationRequestResponsibilityResponse(
        Long id,
        String responsibility,
        LocalDateTime createdDate

) {
}
