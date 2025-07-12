 package com.fractal.domain.localization.language.dto;

 import java.time.LocalDateTime;

public record LanguageResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate
) {}
