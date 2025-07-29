package com.fractal.domain.authorization.role.dto;

import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;

import java.time.LocalDateTime;
import java.util.List;

public record RoleResponse(
        Long id,
        String code,
        String name,
        List<RoleMenuResponse> menus,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
