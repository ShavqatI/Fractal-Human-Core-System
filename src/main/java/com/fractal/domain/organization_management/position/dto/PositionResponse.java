package com.fractal.domain.organization_management.position.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;

import java.time.LocalDateTime;

public record PositionResponse(
        Long id,
        String code,
        String name,
        String description,
        DepartmentCompactResponse department,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {

}
