package com.fractal.domain.localization.layout_label.dto;

import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailResponse;

import java.time.LocalDateTime;
import java.util.List;

public record LayoutLabelResponse(
        Long id,
        String name,
        List<LayoutLabelDetailResponse> details,
        LocalDateTime createdDate
) {
}
