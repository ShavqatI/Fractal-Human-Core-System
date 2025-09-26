package com.fractal.domain.learning_develpment.learning.learner.external.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.contact.ExternalLearnerContact;

public interface ExternalParticipantContactMapperService {
    ContactResponse toDTO(ExternalLearnerContact contact);
    ExternalLearnerContact toEntity(ContactRequest dto);
    ExternalLearnerContact toEntity(ExternalLearnerContact contact, ContactRequest dto);
}


