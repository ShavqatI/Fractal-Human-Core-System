package com.fractal.domain.employment.punishment.type.dto;

import java.time.LocalDateTime;

public record PunishmentTypeResponse(
        Long id,
        String code,
        String name,
        Integer duration,
        LocalDateTime createdDate
) {
}
