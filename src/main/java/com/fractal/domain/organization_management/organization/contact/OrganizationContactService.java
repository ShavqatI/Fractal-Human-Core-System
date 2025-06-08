package com.fractal.domain.organization_management.organization.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

public interface OrganizationContactService {

    ContactResponse toDTO(OrganizationContact contact);
    OrganizationContact toEntity(ContactRequest dto);
    OrganizationContact update(Long id, ContactRequest dto);
    void delete(OrganizationContact contact);
    OrganizationContact findById(Long id);
}
