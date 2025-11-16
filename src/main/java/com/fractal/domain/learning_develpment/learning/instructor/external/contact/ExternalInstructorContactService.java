package com.fractal.domain.learning_develpment.learning.instructor.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface ExternalInstructorContactService {

    ExternalInstructorContact create(Long instructorId, ContactRequest dto);

    List<ExternalInstructorContact> getAllByExternalInstructorId(Long instructorId);

    ExternalInstructorContact getById(Long instructorId, Long id);

    ExternalInstructorContact update(Long instructorId, Long id, ContactRequest dto);

    void delete(Long instructorId, Long id);

    ContactResponse toDTO(ExternalInstructorContact contact);

}
