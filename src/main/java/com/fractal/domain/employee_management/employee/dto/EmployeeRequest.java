package com.fractal.domain.employee_management.employee.dto;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.identification_document.dto.IdentificationDocumentRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
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
        List<ContactRequest> contacts,
        List<EducationRequest> educations,
        List<RelativeRequest> relatives,
        List<MilitaryServiceRequest> militaryServices,
        List<EmploymentHistoryRequest> employmentHistories,
        List<EmploymentRequest> employments,
        List<MultipartFile> files,
        Long statusId
){

}
