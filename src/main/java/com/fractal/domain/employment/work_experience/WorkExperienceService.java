package com.fractal.domain.employment.work_experience;

import com.fractal.domain.employment.work_experience.separation_reason.SeparationReason;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonResponse;

import java.util.List;

public interface WorkExperienceService {
    WorkExperience getById(Long id);
    WorkExperience save(WorkExperience workExperience);
}
