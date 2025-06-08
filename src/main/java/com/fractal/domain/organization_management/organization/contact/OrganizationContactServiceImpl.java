package com.fractal.domain.organization_management.organization.contact;

import com.fractal.domain.contact.ContactService;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.type.ContactTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationContactServiceImpl implements OrganizationContactService {

    private final OrganizationContactRepository resourceRepository;
    private final ContactService contactService;
    private final ContactTypeService contactTypeService;

    @Override
    public ContactResponse toDTO(OrganizationContact contact) {
        return contactService.toDTO(contact);
    }

    @Override
    public OrganizationContact toEntity(ContactRequest dto) {
        return (OrganizationContact) contactService.toEntity(dto);
    }

    @Override
    public OrganizationContact update(Long id, ContactRequest dto) {
        try {
            OrganizationContact contact = findById(id);
            contact.setContactType(contactTypeService.getById(dto.contactTypeId()));
            contact.setValue(dto.value());
            return resourceRepository.save(contact);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(OrganizationContact contact) {
        resourceRepository.delete(contact);
    }

    @Override
    public OrganizationContact findById(Long id) {
        return resourceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }
}
