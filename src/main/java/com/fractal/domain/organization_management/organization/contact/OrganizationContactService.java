package com.fractal.domain.organization_management.organization.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface OrganizationContactService {
    OrganizationContact create(Long organizationId, ContactRequest dto);

    List<OrganizationContact> getAllByOrganizationId(Long organizationId);

    OrganizationContact getById(Long organizationId, Long id);

    OrganizationContact update(Long organizationId, Long id, ContactRequest dto);

    void delete(Long organizationId, Long id);

    ContactResponse toDTO(OrganizationContact contact);
}
