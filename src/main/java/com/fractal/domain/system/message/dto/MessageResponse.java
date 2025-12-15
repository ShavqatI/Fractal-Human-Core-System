package com.fractal.domain.system.message.dto;

import com.fractal.domain.localization.language.dto.LanguageResponse;
import com.fractal.domain.system.message.type.dto.MessageTypeResponse;

import java.time.LocalDateTime;

public record MessageResponse(
        Long id,
        MessageTypeResponse messageType,
        String code,
        String name,
        String description,
        LanguageResponse language,
        LocalDateTime createdDate
) {
}
