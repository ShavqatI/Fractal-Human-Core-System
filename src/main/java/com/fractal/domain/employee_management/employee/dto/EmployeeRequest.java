package com.fractal.domain.employee_management.employee.dto;

import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import org.springframework.web.multipart.MultipartFile;

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
        List<CitizenshipRequest> citizenships,
        List<EmployeeAddressRequest> addresses,
        List<EducationRequest> educations,
        List<RelativeRequest> relatives,
        List<MilitaryServiceRequest> militaryServices,
        List<EmploymentHistoryRequest> employmentHistories,

        List<MultipartFile> files,
        Long statusId
){

}
