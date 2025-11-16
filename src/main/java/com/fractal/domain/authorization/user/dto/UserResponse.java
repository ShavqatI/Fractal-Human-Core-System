package com.fractal.domain.authorization.user.dto;

import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(
        Long id,
        String username,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled,

        List<UserRoleResponse> roles,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
