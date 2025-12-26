package com.fractal.domain.system.message.dto;

import java.time.LocalDateTime;

public record MessageCompactResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
