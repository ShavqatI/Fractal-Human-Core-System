package com.fractal.domain.organization_management.organization.address;

import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;

import java.util.List;

public interface OrganizationAddressService {

    OrganizationAddress create(Long organizationId, OrganizationAddressRequest dto);

    OrganizationAddress getById(Long organizationId, Long id);

    List<OrganizationAddress> getAllByOrganizationId(Long organizationId);

    OrganizationAddress update(Long organizationId, Long id, OrganizationAddressRequest dto);

    void delete(Long organizationId, Long id);

    OrganizationAddressResponse toDTO(OrganizationAddress address);
}
