package com.fractal.domain.organization_management.organization;

import com.fractal.domain.organization_management.organization.address.OrganizationAddress;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;

import java.util.List;

public interface OrganizationService {
    Organization create(OrganizationRequest dto);

    List<Organization> getAll();

    List<Organization> getAllTopLevel();

    Organization getByCode(String code);

    Organization getById(Long id);

    Organization update(Long id, OrganizationRequest dto);

    void deleteById(Long id);

    OrganizationResponse toDTO(Organization organization);

    OrganizationCompactResponse toCompactDTO(Organization organization);

    Organization save(Organization organization);

    Organization addChild(Long id, OrganizationRequest dto);

    Organization updateChild(Long id, Long childId, OrganizationRequest dto);

    Organization deleteChild(Long id, Long childId);

    Organization getHeadOffice();
    OrganizationAddress getActiveAddress(Organization organization);
}
