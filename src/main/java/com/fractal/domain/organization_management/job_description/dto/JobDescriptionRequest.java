package com.fractal.domain.organization_management.job_description.dto;

import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;

import java.time.LocalDate;
import java.util.List;

public record JobDescriptionRequest(
        String title,
        String summary,
        LocalDate effectiveDate,
        String status,
        Long positionId,
        List<ResponsibilityRequest> responsibilities,
        List<QualificationRequest> qualifications,
        List<RequiredExperienceRequest> requiredExperiences
) {}
