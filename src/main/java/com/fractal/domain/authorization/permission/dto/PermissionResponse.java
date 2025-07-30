package com.fractal.domain.authorization.permission.dto;

import com.fractal.domain.authorization.role.dto.RoleResponse;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;

import java.time.LocalDateTime;

public record PermissionResponse(
        Long id,
        RoleResponse role,
        MenuActionResponse menuAction,
        StatusResponse status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
