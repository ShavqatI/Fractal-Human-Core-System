package com.fractal.domain.system.message.type.dto;

import java.time.LocalDateTime;

public record MessageTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
