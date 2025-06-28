package com.fractal.domain.navigation.action.dto;

import java.util.List;

public record ActionRequest(
        String name,
        String url,
        String icon,
        Long layoutLabelId,
        Long actionTypeId,
        Long actionCategoryId
) {}
