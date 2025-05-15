package com.fractal.domain.organization_management.job_description.required_experience;

import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RequiredExperienceServiceImpl implements RequiredExperienceService {
     private final RequiredExperienceRepository requiredExperienceRepository;
    @Override
    public RequiredExperienceResponse toDTO(RequiredExperience requiredExperience) {
        return new RequiredExperienceResponse(
                requiredExperience.getId(),
                requiredExperience.getDescription(),
                requiredExperience.getRequiredYears(),
                requiredExperience.getDomain(),
                requiredExperience.getLevel(),
                requiredExperience.getStartDate(),
                requiredExperience.getEndDate(),
                requiredExperience.getMandatory(),
                requiredExperience.getNotes(),
                requiredExperience.getCreatedDate()
        );
    }

    @Override
    public RequiredExperience toEntity(RequiredExperienceRequest dto) {
        return RequiredExperience.builder()
                .description(dto.description())
                .requiredYears(dto.requiredYears())
                .domain(dto.domain())
                .level(dto.level())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .mandatory(dto.mandatory())
                .notes(dto.notes())
                .build();
    }

    @Override
    public RequiredExperience findById(Long id) {
        return requiredExperienceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("RequiredExperience with id: " + id + " not found"));
    }

    @Override
    public RequiredExperience update(Long id, RequiredExperienceRequest dto) {
        RequiredExperience requiredExperience = findById(id);
        requiredExperience.setDescription(dto.description());
        requiredExperience.setRequiredYears(dto.requiredYears());
        requiredExperience.setDomain(dto.domain());
        requiredExperience.setLevel(dto.level());
        requiredExperience.setStartDate(dto.startDate());
        requiredExperience.setEndDate(dto.endDate());
        requiredExperience.setMandatory(dto.mandatory());
        requiredExperience.setNotes(dto.notes());
       return requiredExperienceRepository.save(requiredExperience);
    }

    @Override
    public void delete(RequiredExperience requiredExperience) {
        requiredExperienceRepository.delete(requiredExperience);
    }
}
