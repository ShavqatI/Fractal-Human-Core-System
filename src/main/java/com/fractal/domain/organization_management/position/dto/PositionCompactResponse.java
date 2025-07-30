package com.fractal.domain.organization_management.position.dto;

import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;

import java.time.LocalDateTime;

public record PositionCompactResponse(
        Long id,
        String code,
        String name
) {

}
