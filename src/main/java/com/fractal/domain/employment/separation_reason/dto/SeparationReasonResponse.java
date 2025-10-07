package com.fractal.domain.employment.separation_reason.dto;

import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeCompactResponse;

import java.time.LocalDateTime;

public record SeparationReasonResponse(
        Long id,
        SeparationReasonTypeCompactResponse separationReasonType,
        LocalDateTime createdDate
) {}
