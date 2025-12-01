package com.fractal.domain.integration.mapping.vacation_type.dto;

public record VacationTypeMappingRequest(
        Long vacationTypeId,
        String referenceType,
        String reference,
        Long statusId
) {
}
