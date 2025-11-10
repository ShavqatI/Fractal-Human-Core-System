package com.fractal.domain.employee_management.employee.dto;

import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.address.dto.EmployeeAddressResponse;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.identification_document.dto.IdentificationDocumentResponse;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

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
        GenderResponse gender,
        MaritalStatusResponse maritalStatus,
        NationalityResponse nationality,
        List<IdentificationDocumentResponse> identificationDocuments,
        List<CitizenshipResponse> citizenships,
        List<EmployeeAddressResponse> addresses,
        List<ContactResponse> contacts,
        List<EducationResponse> educations,
        List<LanguageSkillResponse> languageSkills,
        List<RelativeResponse> relatives,
        List<MilitaryServiceResponse> militaryServices,
        List<EmploymentResponse> employments,
        List<EmployeeResourceResponse> resources,
        StatusCompactResponse status,
        String profilePhoto,
        LocalDateTime createdDate

){ }
