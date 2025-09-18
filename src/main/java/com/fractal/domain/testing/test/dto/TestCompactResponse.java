package com.fractal.domain.testing.test.dto;

public record TestCompactResponse(
        Long id,
        String title,
        String description,
        Integer durationMinutes
) {
}
