package com.fractal.domain.employment.internal.order.dto;

import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InternalEmploymentOrderResponse(
        Long id,
        LocalDate date,
        String number,
        OrderTypeResponse orderType,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
