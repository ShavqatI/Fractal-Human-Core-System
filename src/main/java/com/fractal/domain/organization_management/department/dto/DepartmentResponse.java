package com.fractal.domain.organization_management.department.dto;

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
        String organizationUnit,
        LocalDateTime createdDate
) {}
