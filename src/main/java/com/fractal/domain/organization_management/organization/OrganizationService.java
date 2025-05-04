package com.fractal.domain.organization_management.organization;

import com.fractal.domain.organization_management.organization.dto.OrganizationCreate;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;

import java.util.List;

public interface OrganizationService {
    Organization create(OrganizationCreate dto);
    List<Organization> getAll();
    Organization getByCode(String code);
    Organization getById(Long id);
    Organization update(Long id, OrganizationCreate dto);
    void deleteById(Long id);
    OrganizationResponse toDTO(Organization organization);
}
