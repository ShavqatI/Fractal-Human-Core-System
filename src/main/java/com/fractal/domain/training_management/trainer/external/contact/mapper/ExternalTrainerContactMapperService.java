package com.fractal.domain.training_management.trainer.external.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.training_management.trainer.external.contact.ExternalTrainerContact;

public interface ExternalTrainerContactMapperService {
    ContactResponse toDTO(ExternalTrainerContact contact);
    ExternalTrainerContact toEntity(ContactRequest dto);
    ExternalTrainerContact toEntity(ExternalTrainerContact contact, ContactRequest dto);
}


