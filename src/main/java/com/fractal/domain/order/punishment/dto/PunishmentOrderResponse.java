package com.fractal.domain.order.punishment.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employment.punishment.dto.PunishmentResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.vacation_management.vacation.dto.VacationResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record PunishmentOrderResponse(
        Long id,
        OrderTypeResponse orderType,
        PunishmentResponse punishment,
        String number,
        LocalDate date,
        String sourceDocument,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
