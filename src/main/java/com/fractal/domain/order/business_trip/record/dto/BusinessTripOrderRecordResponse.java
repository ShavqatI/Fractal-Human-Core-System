package com.fractal.domain.order.business_trip.record.dto;

import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;

import java.time.LocalDateTime;

public record BusinessTripOrderRecordResponse(
        Long id,
        BusinessTripResponse businessTrip,
        LocalDateTime createdDate

) {
}
