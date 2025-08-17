package com.fractal.domain.employee_management.work_experience.mapper;

import com.fractal.domain.employee_management.work_experience.EmployeeWorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;

public interface EmployeeWorkExperienceMapperService {
    WorkExperienceResponse toDTO(EmployeeWorkExperience workExperience);
    EmployeeWorkExperience toEntity(WorkExperienceRequest dto);
    EmployeeWorkExperience toEntity(EmployeeWorkExperience workExperience, WorkExperienceRequest dto);
}


