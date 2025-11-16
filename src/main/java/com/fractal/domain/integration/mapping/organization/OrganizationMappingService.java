package com.fractal.domain.integration.mapping.organization;

import com.fractal.domain.integration.mapping.organization.dto.OrganizationMappingRequest;
import com.fractal.domain.integration.mapping.organization.dto.OrganizationMappingResponse;

import java.util.List;

public interface OrganizationMappingService {

    OrganizationMapping create(OrganizationMappingRequest dto);

    List<OrganizationMapping> getAll();

    OrganizationMapping getById(Long id);

    OrganizationMapping update(Long id, OrganizationMappingRequest dto);

    void deleteById(Long id);

    OrganizationMappingResponse toDTO(OrganizationMapping organizationMapping);
}
