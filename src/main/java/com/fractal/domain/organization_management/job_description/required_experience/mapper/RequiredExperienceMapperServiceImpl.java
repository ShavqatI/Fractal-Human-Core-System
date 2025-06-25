package com.fractal.domain.organization_management.job_description.required_experience.mapper;

import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperience;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RequiredExperienceMapperServiceImpl implements RequiredExperienceMapperService {

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
        return mapToEntity(new RequiredExperience(),dto);
    }

    @Override
    public RequiredExperience toEntity(RequiredExperience requiredExperience, RequiredExperienceRequest dto) {
        return mapToEntity(requiredExperience,dto);
    }

    private RequiredExperience mapToEntity(RequiredExperience requiredExperience, RequiredExperienceRequest dto) {
        requiredExperience.setDescription(dto.description());
        requiredExperience.setRequiredYears(dto.requiredYears());
        requiredExperience.setDomain(dto.domain());
        requiredExperience.setLevel(dto.level());
        requiredExperience.setStartDate(dto.startDate());
        requiredExperience.setEndDate(dto.endDate());
        requiredExperience.setMandatory(dto.mandatory());
        requiredExperience.setNotes(dto.notes());
       return requiredExperience;
    }
}
