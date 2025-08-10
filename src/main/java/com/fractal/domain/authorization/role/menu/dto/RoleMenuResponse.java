package com.fractal.domain.authorization.role.menu.dto;

import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.navigation.menu.dto.MenuCompactResponse;

import java.time.LocalDateTime;

public record RoleMenuResponse(
        Long id,
        MenuCompactResponse menu,
        StatusResponse status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
