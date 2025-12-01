package com.fractal.domain.authorization.user.dto;

import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;

import java.time.LocalDateTime;
import java.util.List;

public record UserCompactResponse(
        Long id,
        String username
) {
}
