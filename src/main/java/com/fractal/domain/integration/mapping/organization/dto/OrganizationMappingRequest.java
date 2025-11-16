package com.fractal.domain.integration.mapping.organization.dto;

public record OrganizationMappingRequest(
        Long organizationId,
        String referenceType,
        String reference,
        Long statusId
) {
}
