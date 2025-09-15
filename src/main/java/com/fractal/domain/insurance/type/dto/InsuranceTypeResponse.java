package com.fractal.domain.insurance.type.dto;

import java.time.LocalDateTime;

public record InsuranceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
