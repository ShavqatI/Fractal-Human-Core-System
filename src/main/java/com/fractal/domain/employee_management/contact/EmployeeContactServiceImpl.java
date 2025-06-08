package com.fractal.domain.employee_management.contact;

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
public class EmployeeContactServiceImpl implements EmployeeContactService {

    private final EmployeeContactRepository resourceRepository;
    private final ContactService contactService;
    private final ContactTypeService contactTypeService;

    @Override
    public ContactResponse toDTO(EmployeeContact contact) {
        return contactService.toDTO(contact);
    }

    @Override
    public EmployeeContact toEntity(ContactRequest dto) {
        return (EmployeeContact) contactService.toEntity(dto);
    }

    @Override
    public EmployeeContact update(Long id, ContactRequest dto) {
        try {
            EmployeeContact contact = findById(id);
            contact.setContactType(contactTypeService.getById(dto.contactTypeId()));
            contact.setValue(dto.value());
            return resourceRepository.save(contact);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void delete(EmployeeContact contact) {
        resourceRepository.delete(contact);
    }

    @Override
    public EmployeeContact findById(Long id) {
        return resourceRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }
}
