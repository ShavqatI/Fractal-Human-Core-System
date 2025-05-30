package com.fractal.domain.recruitment.vacncy.experience.dto;

import java.time.LocalDateTime;

public record ExperienceResponse(
        Long id,
        String description,
        Integer requiredYears,
        String domain,
        String level,
        Boolean mandatory,
        String notes,
        LocalDateTime createdDate
)
{}
