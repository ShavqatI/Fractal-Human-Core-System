package com.fractal.domain.profile.candidate.language_skill;

import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;

import java.util.List;

public interface CandidateProfileLanguageSkillService {
    CandidateLanguageSkill create(LanguageSkillRequest dto);
    List<CandidateLanguageSkill> getAll();
    CandidateLanguageSkill getById(Long id);
    CandidateLanguageSkill update(Long id, LanguageSkillRequest dto);
    void delete(Long id);
    LanguageSkillResponse toDTO(CandidateLanguageSkill candidateLanguageSkill);


}
