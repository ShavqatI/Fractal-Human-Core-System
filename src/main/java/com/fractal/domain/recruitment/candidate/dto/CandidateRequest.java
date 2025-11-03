package com.fractal.domain.recruitment.candidate.dto;

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

public record CandidateRequest(
        String lastName,
        String firstName,
        String patronymicName,
        LocalDate birthDate,
        String tin,
        String ssn,
        Long genderId,
        Long maritalStatusId,
        Long nationalityId,
        List<IdentificationDocumentRequest> identificationDocuments,
        List<CitizenshipRequest> citizenships,
        List<CandidateAddressRequest> addresses,
        List<ContactRequest> contacts,
        List<EducationRequest> educations,
        List<LanguageSkillRequest> languageSkills,
        List<ExternalEmploymentRequest> employments,
        List<CandidateProfessionalExperienceRequest> professionalExperiences,
        List<MilitaryServiceRequest> militaryServices,
        List<CandidateResourceRequest> resources,
        Long statusId

) {
}
