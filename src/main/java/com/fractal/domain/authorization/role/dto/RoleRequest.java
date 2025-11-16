package com.fractal.domain.authorization.role.dto;

import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;

import java.util.List;

public record RoleRequest(
        String code,
        String name,
        List<RoleMenuRequest> menus
) {
}
