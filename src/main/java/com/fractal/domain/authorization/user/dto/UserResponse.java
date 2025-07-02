package com.fractal.domain.authorization.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String username,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) { }
