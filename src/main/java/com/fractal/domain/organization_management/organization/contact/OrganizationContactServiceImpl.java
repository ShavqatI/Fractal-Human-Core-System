package com.fractal.domain.organization_management.organization.contact;

import com.fractal.domain.contact.ContactService;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.type.ContactTypeService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.contact.mapper.OrganizationContactMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationContactServiceImpl implements OrganizationContactService {

    private final OrganizationContactRepository contactRepository;
    private final ContactService contactService;
    private final OrganizationContactMapperService contactMapperService;
    private final OrganizationService organizationService;

    @Override
    @Transactional
    public OrganizationContact create(Long organizationId, ContactRequest dto) {
        var organization = organizationService.getById(organizationId);
        var contact = contactMapperService.toEntity(dto);
        organization.addContact(contact);
        organizationService.save(organization);
        return contact;
    }

    @Override
    public List<OrganizationContact> getAllByOrganizationId(Long organizationId) {
        return contactRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public OrganizationContact getById(Long organizationId, Long id) {
        return contactRepository.findByOrganizationIdAndId(organizationId,id).orElseThrow(()-> new ResourceNotFoundException("Organization contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public OrganizationContact update(Long organizationId, Long id, ContactRequest dto) {
        var organization = organizationService.getById(organizationId);
        var contact = organization.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization contact with id: " + id + " not found"));
        contact = contactRepository.save(contactMapperService.toEntity(contact,dto));
        organizationService.save(organization);
        return contact;
    }

    @Override
    @Transactional
    public void delete(Long organizationId, Long id) {
        var organization = organizationService.getById(organizationId);
        var contact = organization.getContacts()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization contact with id: " + id + " not found"));
        organization.removeContact(contact);
        contactRepository.delete(contact);
        organizationService.save(organization);
    }

    @Override
    public ContactResponse toDTO(OrganizationContact contact) {
        return contactService.toDTO(contact);
    }
}
