package com.fractal.domain.recruitment.candidate.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressRequest;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
        List<CandidateCitizenshipRequest> citizenships,
        List<CandidateAddressRequest> addresses,
        List<ContactRequest> contacts,
        List<EducationRequest> educations,
        List<MilitaryServiceRequest> militaryServices,
        List<EmploymentHistoryRequest> employmentHistories,
        List<MultipartFile> files

) {
}
