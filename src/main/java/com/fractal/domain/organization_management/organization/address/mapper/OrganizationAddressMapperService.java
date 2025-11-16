package com.fractal.domain.organization_management.organization.address.mapper;

import com.fractal.domain.organization_management.organization.address.OrganizationAddress;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;

public interface OrganizationAddressMapperService {
    OrganizationAddressResponse toDTO(OrganizationAddress address);

    OrganizationAddress toEntity(OrganizationAddressRequest dto);

    OrganizationAddress toEntity(OrganizationAddress address, OrganizationAddressRequest dto);
}


