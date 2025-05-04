package com.fractal.domain.organization_management.department.dto;

import com.fractal.domain.organization_management.organization_unit.OrganizationUnitDto;

import java.time.LocalDateTime;
import java.util.List;

public record DepartmentResponseDto(
        Long id,
        String code,
        String name,
        int level,
        String levelMap,
        String parent,
        List<DepartmentResponseDto> children,
        String organizationUnit,
        LocalDateTime createdDate
) {}
