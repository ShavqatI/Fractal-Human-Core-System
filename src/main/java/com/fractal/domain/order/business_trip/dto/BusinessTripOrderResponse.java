package com.fractal.domain.order.business_trip.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordRequest;
import com.fractal.domain.order.business_trip.record.dto.BusinessTripOrderRecordResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripOrderResponse(
        Long id,
        OrderTypeResponse orderType,
        List<BusinessTripOrderRecordResponse> records,
        String number,
        LocalDate date,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
