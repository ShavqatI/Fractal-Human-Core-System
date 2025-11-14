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

import java.time.LocalDate;
import java.util.List;

public record CandidateAccountRequest(
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        Long genderId,
        List<ContactRequest> contacts
) { }
