package com.fractal.domain.recruitment.candidate.dto;

import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.organization_management.organization.address.dto.OrganizationAddressResponse;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;
import com.fractal.domain.recruitment.candidate.address.dto.CandidateAddressResponse;
import com.fractal.domain.recruitment.candidate.citizenship.dto.CandidateCitizenshipResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

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
        //List<IdentificationDocumentResponse> identificationDocuments,
        List<CandidateCitizenshipResponse> citizenships,
        List<CandidateAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<EducationResponse> educations,
        //List<MilitaryServiceResponse> militaryServices,
        //List<EmploymentHistoryResponse> employmentHistories,
        //List<ResourceResponse> resources,
        StatusCompactResponse status,
        LocalDateTime createdDate
)
{ }
