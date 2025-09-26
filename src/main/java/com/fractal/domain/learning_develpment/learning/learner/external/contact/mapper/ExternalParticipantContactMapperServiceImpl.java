package com.fractal.domain.learning_develpment.learning.learner.external.contact.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.learning_develpment.learning.learner.external.contact.ExternalLearnerContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ExternalParticipantContactMapperServiceImpl implements ExternalParticipantContactMapperService {
    private final ContactMapperService mapperService;
    @Override
    public ContactResponse toDTO(ExternalLearnerContact contact) {
        return mapperService.toDTO(contact);
    }

    @Override
    public ExternalLearnerContact toEntity(ContactRequest dto) {
        return mapToEntity(new ExternalLearnerContact(),mapperService.toEntity(dto));
    }

    @Override
    public ExternalLearnerContact toEntity(ExternalLearnerContact contact, ContactRequest dto) {
        return mapToEntity(contact,mapperService.toEntity(contact,dto));
    }

    private ExternalLearnerContact mapToEntity(ExternalLearnerContact externalLearnerContact, Contact contact) {
        externalLearnerContact.setContactType(contact.getContactType());
        externalLearnerContact.setValue(contact.getValue());
        return externalLearnerContact;
    }
}
