 package com.fractal.domain.navigation.action.dto;

 import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;
 import com.fractal.domain.navigation.action.category.dto.ActionCategoryResponse;
 import com.fractal.domain.navigation.action.type.dto.ActionTypeResponse;

 import java.time.LocalDateTime;

public record ActionResponse(
        Long id,
        String name,
        String url,
        String icon,
        LayoutLabelResponse layoutLabel,
        ActionTypeResponse actionType,
        ActionCategoryResponse actionCategory,
        LocalDateTime createdDate
) {}
