package com.fractal.domain.recruitment.vacncy.experience.dto;

public record ExperienceRequest(
        String description,
        Integer requiredYears,
        String domain,
        String level,
        Boolean mandatory,
        String notes
) {
}
