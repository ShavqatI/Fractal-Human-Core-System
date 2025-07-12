 package com.fractal.domain.navigation.action.dto;

 import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;

 import java.time.LocalDateTime;

public record ActionResponse(
        Long id,
        String name,
        String url,
        String icon,
        LayoutLabelResponse layoutLabel,
        String actionType,
        String actionCategory,
        LocalDateTime createdDate
) {}
