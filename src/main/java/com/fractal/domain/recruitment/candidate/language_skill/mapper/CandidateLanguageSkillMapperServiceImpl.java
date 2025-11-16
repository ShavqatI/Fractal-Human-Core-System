package com.fractal.domain.recruitment.candidate.language_skill.mapper;

import com.fractal.domain.education.language_skill.LanguageSkill;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.education.language_skill.mapper.LanguageSkillMapperService;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateLanguageSkillMapperServiceImpl implements CandidateLanguageSkillMapperService {

    private final LanguageSkillMapperService mapperService;

    @Override
    public LanguageSkillResponse toDTO(CandidateLanguageSkill languageSkill) {
        return mapperService.toDTO(languageSkill);
    }

    @Override
    public CandidateLanguageSkill toEntity(LanguageSkillRequest dto) {
        return convert(new CandidateLanguageSkill(), mapperService.toEntity(dto));
    }

    @Override
    public CandidateLanguageSkill toEntity(CandidateLanguageSkill languageSkill, LanguageSkillRequest dto) {
        return convert(languageSkill, mapperService.toEntity(languageSkill, dto));
    }

    private CandidateLanguageSkill convert(CandidateLanguageSkill candidateLanguageSkill, LanguageSkill languageSkill) {
        candidateLanguageSkill.setLanguage(languageSkill.getLanguage());
        candidateLanguageSkill.setLanguageProficiency(languageSkill.getLanguageProficiency());
        return candidateLanguageSkill;
    }


}
