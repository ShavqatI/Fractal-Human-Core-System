package com.fractal.domain.employee_management.business_trip.order.dto;

import com.fractal.domain.employee_management.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripOrderResponse(
        Long id,
        Long number,
        OrderTypeResponse orderType,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
