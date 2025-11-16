package com.fractal.domain.organization_management.organization.mapper;

import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;

public interface OrganizationMapperService {
    OrganizationResponse toDTO(Organization organization);

    OrganizationCompactResponse toCompactDTO(Organization organization);

    Organization toEntity(OrganizationRequest dto);

    Organization toEntity(Organization organization, OrganizationRequest dto);
}


