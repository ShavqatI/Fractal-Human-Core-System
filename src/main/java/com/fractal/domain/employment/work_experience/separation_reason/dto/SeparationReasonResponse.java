package com.fractal.domain.employment.work_experience.separation_reason.dto;

import com.fractal.domain.dictionary.separation_reason_type.SeparationReasonType;
import com.fractal.domain.dictionary.separation_reason_type.dto.SeparationReasonTypeCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.unit.dto.OrganizationUnitResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record SeparationReasonResponse(
        Long id,
        SeparationReasonTypeCompactResponse separationReasonType,
        LocalDateTime createdDate
) {}
