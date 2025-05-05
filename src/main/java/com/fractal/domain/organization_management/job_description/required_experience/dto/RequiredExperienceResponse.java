package com.fractal.domain.organization_management.job_description.required_experience.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RequiredExperienceResponse(
        Long id,
        String description,
        Integer requiredYears,
        String domain,
        String level,
        LocalDate startDate,
        LocalDate endDate,
        Boolean mandatory,
        String notes,
        LocalDateTime createdDate
)
{}
