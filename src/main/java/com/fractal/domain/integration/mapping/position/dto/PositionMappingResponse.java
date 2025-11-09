package com.fractal.domain.integration.mapping.position.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;

import java.time.LocalDateTime;

public record PositionMappingResponse(
        Long id,
        PositionCompactResponse position,
        String referenceType,
        String reference,
        StatusCompactResponse status,
        LocalDateTime createdDate

) { }
