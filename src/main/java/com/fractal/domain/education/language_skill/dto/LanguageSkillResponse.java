package com.fractal.domain.education.language_skill.dto;

import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyResponse;
import com.fractal.domain.localization.language.dto.LanguageResponse;

import java.time.LocalDateTime;

public record LanguageSkillResponse(
        Long id,
        LanguageResponse language,
        LanguageProficiencyResponse languageProficiency,
        LocalDateTime createdDate
) {
}
