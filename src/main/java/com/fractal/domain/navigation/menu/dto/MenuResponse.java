 package com.fractal.domain.navigation.menu.dto;

 import java.time.LocalDateTime;
 import java.util.List;

public record MenuResponse(
        Long id,
        String name,
        String url,
        Integer level,
        String icon,
        Long layoutLabelId,
        Integer sequence,
        List<MenuResponse> children,
        LocalDateTime createdDate
) {}
