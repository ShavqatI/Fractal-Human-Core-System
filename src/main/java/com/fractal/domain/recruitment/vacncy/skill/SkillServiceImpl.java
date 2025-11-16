package com.fractal.domain.recruitment.vacncy.skill;

import com.fractal.domain.recruitment.vacncy.skill.dto.SkillRequest;
import com.fractal.domain.recruitment.vacncy.skill.dto.SkillResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public SkillResponse toDTO(Skill skill) {
        return new SkillResponse(
                skill.getId(),
                skill.getDescription(),
                skill.getCreatedDate()
        );
    }

    @Override
    public Skill toEntity(SkillRequest dto) {
        return Skill.builder().description(dto.description()).build();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Qualification with id: " + id + " not found"));

    }

    @Override
    public Skill update(Long id, SkillRequest dto) {
        Skill skill = findById(id);
        skill.setDescription(dto.description());
        return skillRepository.save(skill);
    }

    @Override
    public void delete(Skill skill) {
        skillRepository.delete(skill);
    }
}
