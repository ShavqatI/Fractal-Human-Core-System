package com.fractal.domain.system.service_provider.type.dto;

import java.time.LocalDateTime;

public record ServiceProviderTypeResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
