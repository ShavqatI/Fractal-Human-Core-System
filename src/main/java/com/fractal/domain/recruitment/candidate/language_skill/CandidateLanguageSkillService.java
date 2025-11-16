package com.fractal.domain.recruitment.candidate.language_skill;


import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;

import java.util.List;

public interface CandidateLanguageSkillService {

    CandidateLanguageSkill create(Long candidateId, LanguageSkillRequest dto);

    List<CandidateLanguageSkill> getAllByCandidateId(Long candidateId);

    CandidateLanguageSkill getById(Long candidateId, Long id);

    CandidateLanguageSkill getById(Long id);

    LanguageSkillResponse toDTO(CandidateLanguageSkill candidateLanguageSkill);

    CandidateLanguageSkill update(Long candidateId, Long id, LanguageSkillRequest dto);

    void delete(Long candidateId, Long id);

    CandidateLanguageSkill save(CandidateLanguageSkill candidateLanguageSkill);

}
