package com.fractal.domain.organization_management.job_description.required_experience;

import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;

import java.util.List;

public interface RequiredExperienceService {
    RequiredExperience create(Long jobDescriptionId, RequiredExperienceRequest dto);

    List<RequiredExperience> getAllByJobDescriptionId(Long jobDescriptionId);

    RequiredExperience getById(Long jobDescriptionId, Long id);

    RequiredExperience update(Long jobDescriptionId, Long id, RequiredExperienceRequest dto);

    void delete(Long jobDescriptionId, Long id);

    RequiredExperienceResponse toDTO(RequiredExperience requiredExperience);
}
