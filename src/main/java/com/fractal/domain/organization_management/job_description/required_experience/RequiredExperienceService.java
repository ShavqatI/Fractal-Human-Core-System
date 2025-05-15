package com.fractal.domain.organization_management.job_description.required_experience;

import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;

public interface RequiredExperienceService {
    RequiredExperienceResponse toDTO(RequiredExperience requiredExperience);
    RequiredExperience toEntity(RequiredExperienceRequest dto);

    RequiredExperience findById(Long id);
    RequiredExperience update(Long id,RequiredExperienceRequest dto);

     void delete(RequiredExperience requiredExperience);
}
