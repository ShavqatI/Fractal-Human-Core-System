package com.fractal.domain.organization_management.organization.address;

import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;

import java.util.List;

public interface OrganizationAddressService {
    OrganizationAddressResponse toDTO(OrganizationAddress organizationAddress);
    OrganizationAddress toEntity(OrganizationAddressRequest dto);
    OrganizationAddress update(OrganizationAddress address,OrganizationAddressRequest dto);
    void delete(OrganizationAddress address);
    List<OrganizationAddress> getAllByOrganizationId(Long organizationId);
}
