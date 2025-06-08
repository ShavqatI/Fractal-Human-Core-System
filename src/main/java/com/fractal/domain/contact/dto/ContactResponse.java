package com.fractal.domain.contact.dto;

import java.time.LocalDateTime;

public record ContactResponse(
        Long id,
        String contactTypeId,
        String value,
        LocalDateTime createdDate
) {
}
