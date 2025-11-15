package com.fractal.domain.recruitment.candidate.usecase.profile.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CandidateProfileResponse(
        Long id,
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        GenderResponse gender,
        List<ContactResponse> contacts,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }
