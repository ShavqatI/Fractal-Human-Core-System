package com.fractal.domain.authorization.user.dto;

import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;

import java.util.List;

public record UserRequest(
        String username,
        String password,
        List<UserRoleRequest> userRoles
) {
}
