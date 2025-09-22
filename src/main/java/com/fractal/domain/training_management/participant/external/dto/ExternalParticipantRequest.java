package com.fractal.domain.training_management.participant.external.dto;

import com.fractal.domain.contact.dto.ContactRequest;

import java.time.LocalDate;
import java.util.List;

public record ExternalParticipantRequest(
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        String tin,
        String ssn,
        Long genderId,
        Long maritalStatusId,
        Long nationalityId,
        List<ContactRequest> contacts,
        Long statusId

) { }
