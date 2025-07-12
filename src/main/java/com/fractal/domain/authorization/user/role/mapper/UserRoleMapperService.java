package com.fractal.domain.authorization.user.role.mapper;

import com.fractal.domain.authorization.user.role.UserRole;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;

public interface UserRoleMapperService {
    UserRoleResponse toDTO(UserRole userRole);
    UserRole toEntity(UserRoleRequest dto);
    UserRole toEntity(UserRole userRole, UserRoleRequest dto);
}


