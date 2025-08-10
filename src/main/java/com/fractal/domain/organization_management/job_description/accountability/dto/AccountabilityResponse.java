package com.fractal.domain.organization_management.job_description.accountability.dto;

import java.time.LocalDateTime;

public record AccountabilityResponse(
        Long id,
        String description,
        String performanceMeasure,
        LocalDateTime createdDate

) {
}
