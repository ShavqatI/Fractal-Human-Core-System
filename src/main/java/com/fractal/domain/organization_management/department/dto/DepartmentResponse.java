package com.fractal.domain.organization_management.department.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record DepartmentResponse(
        Long id,
        String name,
        String levelMap,
        String parent,
        List<DepartmentResponse> children,
        OrganizationUnitResponse organizationUnit,
        LocalDate openDate,
        String openReason,
        LocalDate closeDate,
        String closeReason,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
