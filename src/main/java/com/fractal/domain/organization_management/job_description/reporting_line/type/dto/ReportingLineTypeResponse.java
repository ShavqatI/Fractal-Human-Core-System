package com.fractal.domain.organization_management.job_description.reporting_line.type.dto;

import java.time.LocalDateTime;

public record ReportingLineTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
