package com.fractal.domain.navigation.menu.dto;

import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;

import java.time.LocalDateTime;
import java.util.List;

public record MenuResponse(
        Long id,
        String name,
        String url,
        Integer level,
        String icon,
        LayoutLabelResponse layoutLabel,
        Integer sequence,
        List<MenuResponse> children,
        List<MenuActionResponse> actions,
        LocalDateTime createdDate
) {
}
