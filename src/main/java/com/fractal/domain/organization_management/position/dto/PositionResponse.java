package com.fractal.domain.organization_management.position.dto;

import java.time.LocalDateTime;

public record PositionResponse(
        Long id,
        String code,
        String name,
        String description,
        String department,
        LocalDateTime createdDate
) {

}
