package com.fractal.domain.learning_develpment.learning.learner.external.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ExternalLearnerResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        String tin,
        String ssn,
        GenderResponse gender,
        MaritalStatusResponse maritalStatus,
        NationalityResponse nationality,
        List<ContactResponse> contacts,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
