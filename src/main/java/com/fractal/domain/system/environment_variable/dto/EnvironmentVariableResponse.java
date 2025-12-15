package com.fractal.domain.system.environment_variable.dto;

import java.time.LocalDateTime;

public record EnvironmentVariableResponse(
        Long id,
        String code,
        String name,
        String value,
        LocalDateTime createdDate
) {
}
