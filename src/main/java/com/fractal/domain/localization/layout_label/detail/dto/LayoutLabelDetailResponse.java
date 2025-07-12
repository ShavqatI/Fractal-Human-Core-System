 package com.fractal.domain.localization.layout_label.detail.dto;

 import java.time.LocalDateTime;

public record LayoutLabelDetailResponse(
        Long id,
        String language,
        String description,
        LocalDateTime createdDate
) {}
