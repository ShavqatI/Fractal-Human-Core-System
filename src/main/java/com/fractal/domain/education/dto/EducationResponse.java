package com.fractal.domain.education.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.education.accreditation_status.dto.AccreditationStatusResponse;
import com.fractal.domain.education.degree_type.dto.DegreeTypeResponse;
import com.fractal.domain.education.document_type.dto.EducationDocumentTypeResponse;
import com.fractal.domain.education.grade_point_average.dto.GradePointAverageResponse;
import com.fractal.domain.education.type.dto.EducationTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EducationResponse(
        Long id,
        EducationTypeResponse educationType,
        EducationDocumentTypeResponse educationDocumentType,
        LocalDate beginDate,
        LocalDate endDate,
        String institutionName,
        String institutionAddress,
        Boolean isForeignInstitution,
        String specialization,
        DegreeTypeResponse degreeType,
        GradePointAverageResponse gradePointAverage,
        AccreditationStatusResponse accreditationStatus,
        Boolean documentVerified,
        String verificationNotes,
        StatusCompactResponse status,
        List<ResourceResponse> resources,
        LocalDateTime createdDate
) {
}
