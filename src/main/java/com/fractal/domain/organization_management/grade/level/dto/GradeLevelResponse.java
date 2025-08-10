package com.fractal.domain.organization_management.grade.level.dto;

import java.time.LocalDateTime;

public record GradeLevelResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
