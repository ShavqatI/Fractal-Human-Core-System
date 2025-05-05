package com.fractal.domain.organization_management.job_description.qualification.dto;

import java.time.LocalDateTime;

public record QualificationResponse(
        Long id,
        String description,
        LocalDateTime createdDate
) {
}
