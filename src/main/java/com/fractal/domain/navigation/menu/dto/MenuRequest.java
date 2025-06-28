package com.fractal.domain.navigation.menu.dto;

import java.util.List;

public record MenuRequest(
        String name,
        String url,
        Integer level,
        String icon,
        Long layoutLabelId,
        Integer sequence,
        List<MenuRequest> children
) {}
