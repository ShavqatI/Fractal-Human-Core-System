package com.fractal.domain.employee_management.business_trip.dto;

import java.time.LocalDate;

public record BusinessTripProlongRequest(
        String description,
        LocalDate startDate,
        LocalDate endDate
) {
}