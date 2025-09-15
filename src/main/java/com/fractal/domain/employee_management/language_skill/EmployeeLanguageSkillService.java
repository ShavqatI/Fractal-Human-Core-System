package com.fractal.domain.employee_management.language_skill;


import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;

import java.util.List;
public interface EmployeeLanguageSkillService {

    EmployeeLanguageSkill create(Long employeeId, LanguageSkillRequest dto);
    List<EmployeeLanguageSkill> getAllByCandidateId(Long employeeId);
    EmployeeLanguageSkill getById(Long employeeId , Long id);
    EmployeeLanguageSkill getById(Long id);
    LanguageSkillResponse toDTO(EmployeeLanguageSkill employeeLanguageSkill);
    EmployeeLanguageSkill update(Long employeeId, Long id, LanguageSkillRequest dto);
    void delete(Long employeeId,Long id);
    EmployeeLanguageSkill save(EmployeeLanguageSkill employeeLanguageSkill);

}
