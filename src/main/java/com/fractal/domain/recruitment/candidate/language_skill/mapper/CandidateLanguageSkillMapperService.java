package com.fractal.domain.recruitment.candidate.language_skill.mapper;

import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;

public interface CandidateLanguageSkillMapperService {
    LanguageSkillResponse toDTO(CandidateLanguageSkill languageSkill);
    CandidateLanguageSkill toEntity(LanguageSkillRequest dto);
    CandidateLanguageSkill toEntity(CandidateLanguageSkill languageSkill, LanguageSkillRequest dto);
}


