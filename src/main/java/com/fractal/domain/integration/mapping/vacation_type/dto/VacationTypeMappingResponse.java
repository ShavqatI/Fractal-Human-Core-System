package com.fractal.domain.integration.mapping.vacation_type.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDateTime;

public record VacationTypeMappingResponse(
        Long id,
        VacationTypeResponse vacationType,
        String referenceType,
        String reference,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
