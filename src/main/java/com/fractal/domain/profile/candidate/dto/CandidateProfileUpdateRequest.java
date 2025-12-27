package com.fractal.domain.profile.candidate.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CandidateProfileUpdateRequest(
        @NotBlank
        String lastName,
        @NotBlank
        String firstName,
        String patronymicName,
        @NotNull
        LocalDate birthDate,
        @NotNull
        Long genderId,
        @NotBlank
        String tin,
        String ssn,
        @NotNull
        Long maritalStatusId,
        @NotNull
        Long nationalityId
) {
}
