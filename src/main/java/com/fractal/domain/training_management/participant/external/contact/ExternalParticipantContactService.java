package com.fractal.domain.training_management.participant.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface ExternalParticipantContactService {

    ExternalParticipantContact create(Long trainerId, ContactRequest dto);
    List<ExternalParticipantContact> getAllByExternalTrainerId(Long trainerId);
    ExternalParticipantContact getById(Long trainerId , Long id);
    ExternalParticipantContact update(Long trainerId, Long id, ContactRequest dto);
    void delete(Long trainerId,Long id);
    ContactResponse toDTO(ExternalParticipantContact contact);

}
