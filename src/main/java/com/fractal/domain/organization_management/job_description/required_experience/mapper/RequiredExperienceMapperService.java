package com.fractal.domain.organization_management.job_description.required_experience.mapper;

import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperience;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;

public interface RequiredExperienceMapperService {
    RequiredExperienceResponse toDTO(RequiredExperience requiredExperience);

    RequiredExperience toEntity(RequiredExperienceRequest dto);

    RequiredExperience toEntity(RequiredExperience requiredExperience, RequiredExperienceRequest dto);
}


