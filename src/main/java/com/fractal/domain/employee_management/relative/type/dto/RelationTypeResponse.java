package com.fractal.domain.employee_management.relative.type.dto;

import java.time.LocalDateTime;

public record RelationTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
