package com.fractal.domain.learning_develpment.learning.learner.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface ExternalLearnerContactService {

    ExternalLearnerContact create(Long learnerId, ContactRequest dto);

    List<ExternalLearnerContact> getAllByExternalLearnerId(Long learnerId);

    ExternalLearnerContact getById(Long learnerId, Long id);

    ExternalLearnerContact update(Long learnerId, Long id, ContactRequest dto);

    void delete(Long learnerId, Long id);

    ContactResponse toDTO(ExternalLearnerContact contact);

}
