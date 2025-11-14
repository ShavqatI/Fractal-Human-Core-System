package com.fractal.domain.recruitment.candidate.usecase.account.dto;

import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CandidateAccountResponse(
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
