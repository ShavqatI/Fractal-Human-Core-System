package com.fractal.domain.organization_management.job_description.required_experience.dto;

import java.time.LocalDate;

public record RequiredExperienceRequest(
        String description,
        Integer requiredYears,
        String domain,
        String level,
        LocalDate startDate,
        LocalDate endDate,
        Boolean mandatory,
        String notes
)
{}
