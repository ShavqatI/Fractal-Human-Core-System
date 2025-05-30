package com.fractal.domain.recruitment.vacncy.experience;

import com.fractal.domain.recruitment.vacncy.experience.dto.ExperienceRequest;
import com.fractal.domain.recruitment.vacncy.experience.dto.ExperienceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ExperienceServiceImpl implements ExperienceService {
     private final ExperienceRepository experienceRepository;
    @Override
    public ExperienceResponse toDTO(Experience experience) {
        return new ExperienceResponse(
                experience.getId(),
                experience.getDescription(),
                experience.getRequiredYears(),
                experience.getDomain(),
                experience.getLevel(),
                experience.getMandatory(),
                experience.getNotes(),
                experience.getCreatedDate()
        );
    }

    @Override
    public Experience toEntity(ExperienceRequest dto) {
        return Experience.builder()
                .description(dto.description())
                .requiredYears(dto.requiredYears())
                .domain(dto.domain())
                .level(dto.level())
                .mandatory(dto.mandatory())
                .notes(dto.notes())
                .build();
    }

    @Override
    public Experience findById(Long id) {
        return experienceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("RequiredExperience with id: " + id + " not found"));
    }

    @Override
    public Experience update(Long id, ExperienceRequest dto) {
        Experience experience = findById(id);
        experience.setDescription(dto.description());
        experience.setRequiredYears(dto.requiredYears());
        experience.setDomain(dto.domain());
        experience.setLevel(dto.level());
        experience.setMandatory(dto.mandatory());
        experience.setNotes(dto.notes());
       return experienceRepository.save(experience);
    }

    @Override
    public void delete(Experience experience) {
        experienceRepository.delete(experience);
    }
}
