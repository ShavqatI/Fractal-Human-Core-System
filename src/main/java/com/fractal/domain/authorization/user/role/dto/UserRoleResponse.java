package com.fractal.domain.authorization.user.role.dto;

import com.fractal.domain.authorization.role.dto.RoleCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;

public record UserRoleResponse(
        Long id,
        RoleCompactResponse role,
        StatusCompactResponse status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
