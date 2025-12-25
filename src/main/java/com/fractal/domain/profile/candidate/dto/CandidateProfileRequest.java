package com.fractal.domain.profile.candidate.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CandidateProfileRequest(
        @NotBlank
        String lastName,
        @NotBlank
        String firstName,
        String patronymicName,
        @NotNull
        LocalDate birthDate,
        @NotNull
        Long genderId,
        String tin,
        String ssn,
        Long maritalStatusId,
        Long nationalityId,
        @NotEmpty
        List<ContactRequest> contacts
) {
}
