package com.fractal.domain.recruitment.interview.type.dto;

import java.time.LocalDateTime;

public record InterviewTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {
}
