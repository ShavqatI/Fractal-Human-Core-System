package com.fractal.domain.organization_management.job_description.authority.dto;

import java.time.LocalDateTime;

public record AuthorityResponse(
        Long id,
        String description,
        String scope,
        LocalDateTime createdDate
) {
}
