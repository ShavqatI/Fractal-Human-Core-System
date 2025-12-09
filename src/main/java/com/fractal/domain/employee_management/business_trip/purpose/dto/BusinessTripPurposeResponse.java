package com.fractal.domain.employee_management.business_trip.purpose.dto;

import java.time.LocalDateTime;

public record BusinessTripPurposeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
