package com.fractal.domain.recruitment.candidate.usecase.account.dto;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CandidateAccountRequest(
        @NotBlank
        String lastName,
        @NotBlank
        String firstName,
        String patronymicName,
        @NotNull
        LocalDate birthDate,
        @NotNull
        Long genderId,
        List<ContactRequest> contacts
) { }
