package com.fractal.domain.employee_management.language_skill.mapper;

import com.fractal.domain.education.language_skill.LanguageSkill;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.education.language_skill.mapper.LanguageSkillMapperService;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeLanguageSkillMapperServiceImpl implements EmployeeLanguageSkillMapperService {

    private final LanguageSkillMapperService mapperService;

    @Override
    public LanguageSkillResponse toDTO(EmployeeLanguageSkill languageSkill) {
        return mapperService.toDTO(languageSkill);
    }

    @Override
    public EmployeeLanguageSkill toEntity(LanguageSkillRequest dto) {
        return convert(new EmployeeLanguageSkill(),mapperService.toEntity(dto));
    }

    @Override
    public EmployeeLanguageSkill toEntity(EmployeeLanguageSkill languageSkill, LanguageSkillRequest dto) {
        return convert(languageSkill,mapperService.toEntity(languageSkill,dto));
    }

    private EmployeeLanguageSkill convert(EmployeeLanguageSkill employeeLanguageSkill, LanguageSkill languageSkill) {
        employeeLanguageSkill.setLanguage(languageSkill.getLanguage());
        employeeLanguageSkill.setLanguageProficiency(languageSkill.getLanguageProficiency());
        return employeeLanguageSkill;
    }


}
