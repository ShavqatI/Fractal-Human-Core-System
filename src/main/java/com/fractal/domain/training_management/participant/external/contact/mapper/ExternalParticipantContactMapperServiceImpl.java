package com.fractal.domain.training_management.participant.external.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.training_management.participant.external.contact.ExternalParticipantContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ExternalParticipantContactMapperServiceImpl implements ExternalParticipantContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(ExternalParticipantContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public ExternalParticipantContact toEntity(ContactRequest dto) {
        return mapToEntity(new ExternalParticipantContact(),mapperService.toEntity(dto));
    }

    @Override
    public ExternalParticipantContact toEntity(ExternalParticipantContact contact, ContactRequest dto) {
        return mapToEntity(contact,mapperService.toEntity(contact,dto));
    }

    private ExternalParticipantContact mapToEntity(ExternalParticipantContact externalParticipantContact, Contact contact) {
        externalParticipantContact.setContactType(contact.getContactType());
        externalParticipantContact.setValue(contact.getValue());
        return externalParticipantContact;
    }
}
