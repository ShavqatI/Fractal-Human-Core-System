 package com.fractal.domain.organization_management.job_description.dto;

 import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
 import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
 import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
 import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
 import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;

 import java.time.LocalDate;
 import java.time.LocalDateTime;
 import java.util.List;

public record JobDescriptionResponse(
        Long id,
        String title,
        String summary,
        LocalDate effectiveDate,
        StatusCompactResponse status,
        PositionCompactResponse position,
        List<ResponsibilityResponse> responsibilities,
        List<QualificationResponse> qualifications,
        List<RequiredExperienceResponse> requiredExperiences,
        LocalDateTime createdDate
) {}
