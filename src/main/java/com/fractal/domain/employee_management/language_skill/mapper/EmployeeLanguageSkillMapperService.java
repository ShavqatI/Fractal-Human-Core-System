package com.fractal.domain.employee_management.language_skill.mapper;

import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkill;

public interface EmployeeLanguageSkillMapperService {
    LanguageSkillResponse toDTO(EmployeeLanguageSkill languageSkill);
    EmployeeLanguageSkill toEntity(LanguageSkillRequest dto);
    EmployeeLanguageSkill toEntity(EmployeeLanguageSkill languageSkill, LanguageSkillRequest dto);
}


