package com.fractal.domain.authorization.role.dto;

import java.time.LocalDateTime;

public record RoleResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
