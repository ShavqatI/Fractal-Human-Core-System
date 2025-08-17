package com.fractal.domain.employee_management.work_experience;

import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;

import java.util.List;

public interface EmployeeWorkExperienceService {

    EmployeeWorkExperience create(Long employeeId, WorkExperienceRequest dto);
    EmployeeWorkExperience getById(Long employeeId, Long id);
    List<EmployeeWorkExperience> getAllByEmployeeId(Long employeeId);
    EmployeeWorkExperience update(Long employeeId, Long id, WorkExperienceRequest dto);
    void delete(Long employeeId, Long id);
    WorkExperienceResponse toDTO(EmployeeWorkExperience address);
}
