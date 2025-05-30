package com.fractal.domain.recruitment.vacncy.skill;

import com.fractal.domain.recruitment.vacncy.skill.dto.SkillRequest;
import com.fractal.domain.recruitment.vacncy.skill.dto.SkillResponse;

public interface SkillService {
    SkillResponse toDTO(Skill skill);
    Skill toEntity(SkillRequest dto);

    Skill findById(Long id);
    Skill update(Long id, SkillRequest dto);
    void delete(Skill skill);
}
