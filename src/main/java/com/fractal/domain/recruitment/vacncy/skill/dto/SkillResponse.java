package com.fractal.domain.recruitment.vacncy.skill.dto;

import java.time.LocalDateTime;

public record SkillResponse(
        Long id,
        String description,
        LocalDateTime createdDate
) {
}
