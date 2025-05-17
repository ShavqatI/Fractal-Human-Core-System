package com.fractal.domain.organization_management.job_description.responsibility.dto;

import java.time.LocalDateTime;

public record ResponsibilityResponse(
        Long id,
        String description,
        LocalDateTime createdDate
) {
}
