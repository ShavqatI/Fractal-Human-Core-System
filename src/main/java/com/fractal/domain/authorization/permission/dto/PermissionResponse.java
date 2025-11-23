package com.fractal.domain.authorization.permission.dto;

import com.fractal.domain.authorization.role.dto.RoleCompactResponse;
import com.fractal.domain.authorization.role.dto.RoleResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;

import java.time.LocalDateTime;

public record PermissionResponse(
        Long id,
        RoleCompactResponse role,
        MenuActionResponse menuAction,
        StatusCompactResponse status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
