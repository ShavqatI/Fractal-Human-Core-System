package com.fractal.domain.employment.work_experience.mapper;

import com.fractal.domain.employment.work_experience.WorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;

public interface WorkExperienceMapperService {
    WorkExperienceResponse toDTO(WorkExperience workExperience);
    WorkExperience toEntity(WorkExperienceRequest dto);
    WorkExperience toEntity(WorkExperience workExperience, WorkExperienceRequest dto);
}


