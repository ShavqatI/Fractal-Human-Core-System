package com.fractal.domain.employee_management.employee.dto;

import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.employee_management.education.dto.EducationResponse;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmployeeResponse(
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
        List<EmployeeAddressResponse> addresses,

        List<ContactResponse> contacts,
        List<EducationResponse> educations,
        List<RelativeResponse> relatives,
        List<MilitaryServiceResponse> militaryServices,
        List<EmploymentHistoryResponse> employmentHistories,
        List<ResourceResponse> resources,
        String status,
        LocalDateTime createdDate

){

}
