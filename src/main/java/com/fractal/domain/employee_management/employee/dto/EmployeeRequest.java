package com.fractal.domain.employee_management.employee.dto;

import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;

import java.time.LocalDate;
import java.util.List;

public record EmployeeRequest(
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
        List<EmploymentHistoryRequest> employmentHistories,
        Long statusId
){

}
