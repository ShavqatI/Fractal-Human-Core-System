package com.fractal.domain.recruitment.candidate.dto;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import org.springframework.web.multipart.MultipartFile;

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
        List<WorkExperienceRequest> workExperiences,
        ///List<MilitaryServiceRequest> militaryServices,
        List<MultipartFile> files

) {
}
