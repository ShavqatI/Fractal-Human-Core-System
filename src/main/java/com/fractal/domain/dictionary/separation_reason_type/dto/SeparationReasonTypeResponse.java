package com.fractal.domain.dictionary.separation_reason_type.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;
import java.util.List;

public record SeparationReasonTypeResponse(
        Long id,
        String code,
        String name,
        String parent,
        List<SeparationReasonTypeResponse> children,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
