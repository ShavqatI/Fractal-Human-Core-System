 package com.fractal.domain.navigation.menu.action.dto;

 import java.time.LocalDateTime;

 public record MenuActionResponse(
        Long id,
        String action,
        LocalDateTime createdDate
) {}
