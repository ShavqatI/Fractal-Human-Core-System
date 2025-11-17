package com.fractal.domain.order.vacation.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.vacation_management.vacation.dto.VacationResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record VacationOrderResponse(
        Long id,
        OrderTypeResponse orderType,
        VacationResponse vacation,
        String number,
        LocalDate date,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
