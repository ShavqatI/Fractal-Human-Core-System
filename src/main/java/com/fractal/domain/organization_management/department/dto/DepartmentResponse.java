package com.fractal.domain.organization_management.department.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.unit.OrganizationUnit;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;

import java.time.LocalDateTime;
import java.util.List;

public record DepartmentResponse(
        Long id,
        String code,
        String name,
        int level,
        String levelMap,
        String parent,
        List<DepartmentResponse> children,
        OrganizationUnitResponse organizationUnit,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
