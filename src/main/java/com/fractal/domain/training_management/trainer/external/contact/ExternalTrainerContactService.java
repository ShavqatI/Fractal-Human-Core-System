package com.fractal.domain.training_management.trainer.external.contact;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;

import java.util.List;

public interface ExternalTrainerContactService {

    ExternalTrainerContact create(Long trainerId, ContactRequest dto);
    List<ExternalTrainerContact> getAllByExternalTrainerId(Long trainerId);
    ExternalTrainerContact getById(Long trainerId , Long id);
    ExternalTrainerContact update(Long trainerId, Long id, ContactRequest dto);
    void delete(Long trainerId,Long id);
    ContactResponse toDTO(ExternalTrainerContact contact);

}
