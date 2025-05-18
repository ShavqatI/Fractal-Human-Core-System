package com.fractal.domain.organization_management.organization;

import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;

import java.util.List;

public interface OrganizationService {
    Organization create(OrganizationRequest dto);
    List<Organization> getAll();
    Organization getByCode(String code);
    Organization getById(Long id);
    Organization update(Long id, OrganizationRequest dto);
    void deleteById(Long id);
    OrganizationResponse toDTO(Organization organization);

    Organization addAddress(Long id,OrganizationAddressRequest dto);
    Organization updateAddress(Long id,Long addressId, OrganizationAddressRequest dto);
    Organization deleteAddress(Long id,Long addressId);
    Organization addChild(Long id,OrganizationRequest dto);
    Organization updateChild(Long id,Long childId,OrganizationRequest dto);

    Organization deleteChild(Long id,Long childId);

}
