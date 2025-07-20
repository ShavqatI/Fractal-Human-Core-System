package com.fractal.domain.authorization.permission.mapper;

import com.fractal.domain.authorization.permission.Permission;
import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.permission.dto.PermissionRequest;
import com.fractal.domain.authorization.permission.dto.PermissionResponse;

public interface PermissionMapperService {
    PermissionResponse toDTO(Permission permission);
    Permission toEntity(PermissionRequest dto);
    Permission toEntity(Permission permission, PermissionRequest dto);
}


