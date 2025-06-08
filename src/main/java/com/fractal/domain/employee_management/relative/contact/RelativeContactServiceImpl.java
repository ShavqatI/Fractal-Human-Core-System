package com.fractal.domain.employee_management.relative.contact;

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
public class RelativeContactServiceImpl implements RelativeContactService {

    private final RelativeContactRepository resourceRepository;
    private final ContactService contactService;
    private final ContactTypeService contactTypeService;

    @Override
    public ContactResponse toDTO(RelativeContact contact) {
        return contactService.toDTO(contact);
    }

    @Override
    public RelativeContact toEntity(ContactRequest dto) {
        return (RelativeContact) contactService.toEntity(dto);
    }

    @Override
    public RelativeContact update(Long id, ContactRequest dto) {
        try {
            RelativeContact contact = findById(id);
            contact.setContactType(contactTypeService.getById(dto.contactTypeId()));
            contact.setValue(dto.value());
            return resourceRepository.save(contact);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(RelativeContact contact) {
        resourceRepository.delete(contact);
    }

    @Override
    public RelativeContact findById(Long id) {
        return resourceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }
}
