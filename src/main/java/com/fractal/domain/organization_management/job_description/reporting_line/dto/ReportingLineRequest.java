package com.fractal.domain.organization_management.job_description.reporting_line.dto;

public record ReportingLineRequest(
        Long positionId,
        Long reportingTypeId,
        Long statusId

) {
}
