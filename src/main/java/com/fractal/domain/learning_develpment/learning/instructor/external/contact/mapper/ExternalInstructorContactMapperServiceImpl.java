package com.fractal.domain.learning_develpment.learning.instructor.external.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.learning_develpment.learning.instructor.external.contact.ExternalInstructorContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ExternalInstructorContactMapperServiceImpl implements ExternalInstructorContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(ExternalInstructorContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public ExternalInstructorContact toEntity(ContactRequest dto) {
        return mapToEntity(new ExternalInstructorContact(),mapperService.toEntity(dto));
    }

    @Override
    public ExternalInstructorContact toEntity(ExternalInstructorContact contact, ContactRequest dto) {
        return mapToEntity(contact,mapperService.toEntity(contact,dto));
    }

    private ExternalInstructorContact mapToEntity(ExternalInstructorContact externalInstructorContact, Contact contact) {
        externalInstructorContact.setContactType(contact.getContactType());
        externalInstructorContact.setValue(contact.getValue());
        return externalInstructorContact;
    }
}
