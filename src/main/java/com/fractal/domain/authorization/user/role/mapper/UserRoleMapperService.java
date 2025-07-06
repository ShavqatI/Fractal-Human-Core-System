package com.fractal.domain.authorization.user.role.mapper;

import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.authorization.user.role.UserRole;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;

public interface UserRoleMapperService {
    UserRoleResponse toDTO(UserRole userRole);
    UserRole toEntity(UserRoleRequest dto);
    UserRole toEntity(UserRole userRole, UserRoleRequest dto);
}


