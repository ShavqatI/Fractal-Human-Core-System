package com.fractal.domain.navigation.action.dto;

public record ActionRequest(
        String name,
        String url,
        String icon,
        Long layoutLabelId,
        Long actionTypeId,
        Long actionCategoryId
) {
}
