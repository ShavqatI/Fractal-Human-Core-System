package com.fractal.domain.organization_management.job_description.required_experience;

import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RequiredExperienceServiceImpl implements RequiredExperienceService {
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
}
