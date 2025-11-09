package com.fractal.domain.integration.mapping.organization.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;

import java.time.LocalDateTime;

public record OrganizationMappingResponse(
        Long id,
        OrganizationCompactResponse organization,
        String referenceType,
        String reference,
        StatusCompactResponse status,
        LocalDateTime createdDate

) { }
