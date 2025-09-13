package com.fractal.domain.education.language_skill.proficiency.dto;

import java.time.LocalDateTime;

public record LanguageProficiencyResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
