package com.fractal.domain.profile.language_skill;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkill;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkillService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileLanguageSkillServiceImpl implements ProfileLanguageSkillService {

   private final EmployeeLanguageSkillService languageSkillService;
   private final AuthenticatedService authenticatedService;

    @Override
    public List<EmployeeLanguageSkill> getAll() {
        return languageSkillService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }

    @Override
    public EmployeeLanguageSkill getById(Long id) {
        return getAll().stream()
                .filter(identificationDocument -> identificationDocument.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public LanguageSkillResponse toDTO(EmployeeLanguageSkill languageSkill) {
        return languageSkillService.toDTO(languageSkill);
    }


}
