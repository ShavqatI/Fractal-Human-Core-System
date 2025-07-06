package com.fractal.domain.authorization.role.menu.dto;

import java.time.LocalDateTime;

public record RoleMenuResponse(
        Long id,
        String menu,
        String status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
