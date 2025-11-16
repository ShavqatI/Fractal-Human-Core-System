package com.fractal.domain.organization_management.organization.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.organization_management.organization.contact.OrganizationContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrganizationContactMapperServiceImpl implements OrganizationContactMapperService {
    private final ContactMapperService mapperService;

    @Override
    public ContactResponse toDTO(OrganizationContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public OrganizationContact toEntity(ContactRequest dto) {
        return mapToEntity(new OrganizationContact(), mapperService.toEntity(dto));
    }

    @Override
    public OrganizationContact toEntity(OrganizationContact contact, ContactRequest dto) {
        return mapToEntity(contact, mapperService.toEntity(contact, dto));
    }

    private OrganizationContact mapToEntity(OrganizationContact organizationContact, Contact contact) {
        organizationContact.setContactType(contact.getContactType());
        organizationContact.setValue(contact.getValue());
        return organizationContact;
    }
}
