package com.fractal.domain.employee_management.business_trip.location.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressResponse;
import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripLocationResponse(
        Long id,
        BusinessTripLocationTypeResponse locationTypeResponse,
        LocalDateTime startTime,
        LocalDateTime endTime,
        List<BusinessTripLocationAddressResponse> addresses,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
