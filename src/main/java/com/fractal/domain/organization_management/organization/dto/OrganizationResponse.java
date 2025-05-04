package com.fractal.domain.organization_management.organization.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record OrganizationResponse (
        Long id,
        String code,
        String name,
        String fullName,
        String tinNumber,
        LocalDate openDate,
        LocalDate closeDate,
        Integer level,
        String levelMap,
        String organizationUnit,
        String parent,
        List<OrganizationResponse> children,
        List<OrganizationAddressResponse> addresses,
        LocalDateTime createdDate
)
{ }
