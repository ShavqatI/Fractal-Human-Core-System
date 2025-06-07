package com.fractal.domain.employee_management.education.dto;

import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EducationResponse(
        Long id,
        String educationType,
        String educationDocumentType,
        LocalDate beginDate,
        LocalDate endDate,
        String institutionName,
        String institutionAddress,
        Boolean isForeignInstitution,
        String specialization,
        String degreeType,
        String gradePointAverage,
        String accreditationStatus,
        Boolean documentVerified,
        String verificationNotes,
        String statusId,
        List<ResourceResponse> resources,
        LocalDateTime createdDate
) {
}
