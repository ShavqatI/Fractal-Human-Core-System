package com.fractal.domain.organization_management.unit.dto;

import java.time.LocalDateTime;

public record OrganizationUnitResponse(
    Long id,
    String code,
    String name,
    String description,
    LocalDateTime createdDate
 )
{}
