package com.fractal.domain.employment.work_experience;

public interface WorkExperienceService {
    WorkExperience getById(Long id);
    WorkExperience save(WorkExperience workExperience);
}
