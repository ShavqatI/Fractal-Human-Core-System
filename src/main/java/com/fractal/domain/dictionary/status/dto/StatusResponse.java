package com.fractal.domain.dictionary.status.dto;

import java.time.LocalDateTime;

public record StatusResponse(
        Long id,
        String code,
        String name,
        String statusCategory,
        String description,
        LocalDateTime createdDate
) {
}
