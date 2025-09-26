package com.fractal.domain.learning_develpment.learning.instructor.external.contact.mapper;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.contact.ExternalInstructorContact;

public interface ExternalInstructorContactMapperService {
    ContactResponse toDTO(ExternalInstructorContact contact);
    ExternalInstructorContact toEntity(ContactRequest dto);
    ExternalInstructorContact toEntity(ExternalInstructorContact contact, ContactRequest dto);
}


