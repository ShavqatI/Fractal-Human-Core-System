package com.fractal.domain.employee_management.employee.dto;

import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentResponse;

import java.time.LocalDate;
import java.util.List;

public record EmployeeResponse(
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
        List<EmploymentHistoryResponse> employmentHistories,
        String status

){

}
