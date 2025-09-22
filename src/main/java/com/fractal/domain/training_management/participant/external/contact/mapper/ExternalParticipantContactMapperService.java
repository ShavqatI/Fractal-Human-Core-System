package com.fractal.domain.training_management.participant.external.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.training_management.participant.external.contact.ExternalParticipantContact;

public interface ExternalParticipantContactMapperService {
    ContactResponse toDTO(ExternalParticipantContact contact);
    ExternalParticipantContact toEntity(ContactRequest dto);
    ExternalParticipantContact toEntity(ExternalParticipantContact contact, ContactRequest dto);
}


