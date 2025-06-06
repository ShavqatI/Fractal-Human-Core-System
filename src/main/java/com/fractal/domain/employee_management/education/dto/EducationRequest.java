package com.fractal.domain.employee_management.education.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record EducationRequest(
        Long educationTypeId,
        Long educationDocumentTypeId,
        LocalDate beginDate,
        LocalDate endDate,
        String institutionName,
        String institutionAddress,
        Boolean isForeignInstitution,
        String specialization,
        Long degreeTypeId,
        Long gradePointAverageId,
        Long accreditationStatusId,
        Boolean documentVerified,
        String verificationNotes,
        Long statusId,
        List<MultipartFile> files
) {
}
