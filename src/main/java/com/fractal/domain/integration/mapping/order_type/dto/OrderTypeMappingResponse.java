package com.fractal.domain.integration.mapping.order_type.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.order.type.dto.OrderTypeResponse;

import java.time.LocalDateTime;

public record OrderTypeMappingResponse(
        Long id,
        OrderTypeResponse orderType,
        String referenceType,
        String reference,
        StatusCompactResponse status,
        LocalDateTime createdDate

) { }
