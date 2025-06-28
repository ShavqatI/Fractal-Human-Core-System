 package com.fractal.domain.navigation.action.dto;

 import java.time.LocalDateTime;
 import java.util.List;

public record ActionResponse(
        Long id,
        String name,
        String url,
        String icon,
        String layoutLabel,
        String actionType,
        String actionCategory,
        LocalDateTime createdDate
) {}
