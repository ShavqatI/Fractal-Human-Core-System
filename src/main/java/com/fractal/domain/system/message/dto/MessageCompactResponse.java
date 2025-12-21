package com.fractal.domain.system.message.dto;

import com.fractal.domain.localization.language.dto.LanguageResponse;
import com.fractal.domain.system.message.type.dto.MessageTypeResponse;

import java.time.LocalDateTime;

public record MessageCompactResponse(
        Long id,
        String code,
        String name,
        String description,
        LocalDateTime createdDate
) {
}
