 package com.fractal.domain.localization.layout_label.detail.dto;

 import com.fractal.domain.localization.language.dto.LanguageResponse;

 import java.time.LocalDateTime;

public record LayoutLabelDetailResponse(
        Long id,
        LanguageResponse language,
        String description,
        LocalDateTime createdDate
) {}
