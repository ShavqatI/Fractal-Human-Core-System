package com.fractal.domain.order.business_trip.record.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.order.business_trip.dto.BusinessTripOrderResponse;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BusinessTripOrderRecordResponse(
        Long id,
        BusinessTripResponse businessTrip,
        LocalDateTime createdDate

) {
}
