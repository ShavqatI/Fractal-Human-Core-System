package com.fractal.domain.authorization.user.role.dto;

import java.time.LocalDateTime;

public record UserRoleResponse(
        Long id,
        String role,
        String status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
