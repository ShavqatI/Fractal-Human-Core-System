package com.fractal.domain.organization_management.job_description.reporting_line.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.job_description.reporting_line.type.dto.ReportingLineTypeResponse;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;

import java.time.LocalDateTime;

public record ReportingLineResponse(
        Long id,
        ReportingLineTypeResponse reportingLineType,
        PositionCompactResponse position,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {
}
