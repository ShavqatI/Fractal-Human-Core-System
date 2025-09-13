package com.fractal.domain.education.language_skill.mapper;

import com.fractal.domain.education.language_skill.LanguageSkill;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;

public interface LanguageSkillMapperService {
    LanguageSkillResponse toDTO(LanguageSkill languageSkill);
    LanguageSkill toEntity(LanguageSkillRequest dto);
    LanguageSkill toEntity(LanguageSkill languageSkill, LanguageSkillRequest dto);
}


