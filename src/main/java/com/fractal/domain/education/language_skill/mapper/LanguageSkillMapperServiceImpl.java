package com.fractal.domain.education.language_skill.mapper;

import com.fractal.domain.education.language_skill.LanguageSkill;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.education.language_skill.proficiency.LanguageProficiencyService;
import com.fractal.domain.localization.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LanguageSkillMapperServiceImpl implements LanguageSkillMapperService {

    private final LanguageService languageService;
    private final LanguageProficiencyService languageProficiencyService;



    @Override
    public LanguageSkillResponse toDTO(LanguageSkill languageSkill) {
        return new LanguageSkillResponse(
                languageSkill.getId(),
                languageService.toDTO(languageSkill.getLanguage()),
                languageProficiencyService.toDTO(languageSkill.getLanguageProficiency()),
                languageSkill.getCreatedDate()
        );
    }

    @Override
    public LanguageSkill toEntity(LanguageSkillRequest dto) {
        return mapToEntity(new LanguageSkill(),dto);
    }

    @Override
    public LanguageSkill toEntity(LanguageSkill languageSkill, LanguageSkillRequest dto) {
       return mapToEntity(languageSkill,dto);
    }

    private LanguageSkill mapToEntity(LanguageSkill languageSkill, LanguageSkillRequest dto) {
        languageSkill.setLanguage(languageService.getById(dto.languageId()));
        languageSkill.setLanguageProficiency(languageProficiencyService.getById(dto.languageProficiencyId()));
        return languageSkill;
    }

}
