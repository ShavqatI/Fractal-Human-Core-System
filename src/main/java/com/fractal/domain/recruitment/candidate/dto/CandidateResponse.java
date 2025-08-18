package com.fractal.domain.recruitment.candidate.dto;

import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;

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
        String gender,
        String maritalStatus,
        String nationality,
        List<IdentificationDocumentResponse> identificationDocuments,
        List<CitizenshipResponse> citizenships,
        List<CandidateAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<EducationResponse> educations,
        List<WorkExperienceResponse> workExperiences,
        //List<MilitaryServiceResponse> militaryServices,
        //List<EmploymentHistoryResponse> employmentHistories,
        //List<ResourceResponse> resources,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }
