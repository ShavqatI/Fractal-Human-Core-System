package com.fractal.domain.employee_management.business_trip.location.type.dto;

import java.time.LocalDateTime;

public record BusinessTripLocationTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
