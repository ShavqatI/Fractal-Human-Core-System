package com.fractal.domain.employee_management.vacation.order.dto;

import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDateTime;
import java.util.List;

public record VacationOrderResponse(
        Long id,
        Long number,
        OrderTypeResponse orderType,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
