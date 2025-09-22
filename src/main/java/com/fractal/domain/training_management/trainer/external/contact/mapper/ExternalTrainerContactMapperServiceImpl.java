package com.fractal.domain.training_management.trainer.external.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.training_management.trainer.external.contact.ExternalTrainerContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ExternalTrainerContactMapperServiceImpl implements ExternalTrainerContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(ExternalTrainerContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public ExternalTrainerContact toEntity(ContactRequest dto) {
        return mapToEntity(new ExternalTrainerContact(),mapperService.toEntity(dto));
    }

    @Override
    public ExternalTrainerContact toEntity(ExternalTrainerContact contact, ContactRequest dto) {
        return mapToEntity(contact,mapperService.toEntity(contact,dto));
    }

    private ExternalTrainerContact mapToEntity(ExternalTrainerContact externalTrainerContact, Contact contact) {
        externalTrainerContact.setContactType(contact.getContactType());
        externalTrainerContact.setValue(contact.getValue());
        return externalTrainerContact;
    }
}
