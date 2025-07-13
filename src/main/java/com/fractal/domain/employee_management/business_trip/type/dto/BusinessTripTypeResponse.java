package com.fractal.domain.employee_management.business_trip.type.dto;

import java.time.LocalDateTime;

public record BusinessTripTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
