package com.fractal.domain.profile.candidate.language_skill;

import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkill;

import java.util.List;

public interface CandidateProfileLanguageSkillService {
    List<EmployeeLanguageSkill> getAll();


    EmployeeLanguageSkill getById(Long id);

    LanguageSkillResponse toDTO(EmployeeLanguageSkill languageSkill);


}
