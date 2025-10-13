package com.fractal.domain.employee_management.relative.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.employee_management.contact.EmployeeContact;
import com.fractal.domain.employee_management.relative.contact.RelativeContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RelativeContactMapperServiceImpl implements RelativeContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(RelativeContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public RelativeContact toEntity(ContactRequest dto) {
        return mapToEntity(new RelativeContact(),mapperService.toEntity(dto));
    }

    @Override
    public RelativeContact toEntity(RelativeContact contact, ContactRequest dto) {
        return mapToEntity(contact,mapperService.toEntity(contact,dto));
    }

    private RelativeContact mapToEntity(RelativeContact relativeContact, Contact contact) {
        relativeContact.setContactType(contact.getContactType());
        relativeContact.setValue(contact.getValue());
        return relativeContact;
    }
}
