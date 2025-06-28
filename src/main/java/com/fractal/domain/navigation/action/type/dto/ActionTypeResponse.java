package com.fractal.domain.navigation.action.type.dto;

import java.time.LocalDateTime;

public record ActionTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
