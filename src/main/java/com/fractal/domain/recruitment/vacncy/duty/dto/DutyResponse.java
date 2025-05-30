package com.fractal.domain.recruitment.vacncy.duty.dto;

import java.time.LocalDateTime;

public record DutyResponse(
        Long id,
        String description,
        LocalDateTime createdDate
) {
}
