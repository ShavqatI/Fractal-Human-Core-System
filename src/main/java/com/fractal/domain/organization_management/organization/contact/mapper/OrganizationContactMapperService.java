package com.fractal.domain.organization_management.organization.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.organization_management.organization.contact.OrganizationContact;

public interface OrganizationContactMapperService {
    ContactResponse toDTO(OrganizationContact contact);

    OrganizationContact toEntity(ContactRequest dto);

    OrganizationContact toEntity(OrganizationContact contact, ContactRequest dto);
}


