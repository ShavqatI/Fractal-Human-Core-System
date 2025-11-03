package com.fractal.domain.recruitment.candidate.dto;

import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
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

public record CandidateResponse(
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
        List<IdentificationDocumentResponse> identificationDocuments,
        List<CitizenshipResponse> citizenships,
        List<CandidateAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<EducationResponse> educations,
        List<LanguageSkillResponse> languageSkills,
        List<ExternalEmploymentResponse> employments,
        List<CandidateProfessionalExperienceResponse> professionalExperiences,
        List<MilitaryServiceResponse> militaryServices,
        List<CandidateResourceResponse> resources,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }
