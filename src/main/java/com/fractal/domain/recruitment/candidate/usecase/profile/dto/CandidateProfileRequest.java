package com.fractal.domain.recruitment.candidate.usecase.profile.dto;

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
        @NotEmpty
        List<ContactRequest> contacts
) { }
