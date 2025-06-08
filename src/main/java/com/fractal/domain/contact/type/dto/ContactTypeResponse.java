package com.fractal.domain.contact.type.dto;

import java.time.LocalDateTime;

public record ContactTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
