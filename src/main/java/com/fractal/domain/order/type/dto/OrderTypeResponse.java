package com.fractal.domain.order.type.dto;

import java.time.LocalDateTime;

public record OrderTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
