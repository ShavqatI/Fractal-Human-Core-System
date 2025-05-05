package com.fractal.domain.organization_management.job_description.dto;

import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.position.Position;

import java.time.LocalDate;
import java.util.List;

public record JobDescriptionRequest(
        String title,
        String summary,
        LocalDate effectiveDate,
        String status,
        Long positionId,
        List<String> responsibilities,
        List<String> qualifications,
        List<RequiredExperienceRequest> requiredExperiences
) {}
