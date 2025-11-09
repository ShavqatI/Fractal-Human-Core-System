package com.fractal.domain.integration.mapping.department.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;

import java.time.LocalDateTime;

public record DepartmentMappingResponse(
        Long id,
        DepartmentCompactResponse department,
        String referenceType,
        String reference,
        StatusCompactResponse status,
        LocalDateTime createdDate

) { }
