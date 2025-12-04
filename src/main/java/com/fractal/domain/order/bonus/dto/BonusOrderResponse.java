package com.fractal.domain.order.bonus.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.order.bonus.record.dto.BonusOrderRecordResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record BonusOrderResponse(
        Long id,
        OrderTypeResponse orderType,
        List<BonusOrderRecordResponse> records,
        String number,
        LocalDate date,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate

) {
}
