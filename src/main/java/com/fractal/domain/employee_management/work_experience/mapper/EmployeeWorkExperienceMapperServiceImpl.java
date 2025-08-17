package com.fractal.domain.employee_management.work_experience.mapper;

import com.fractal.domain.employee_management.work_experience.EmployeeWorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.employment.work_experience.mapper.WorkExperienceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeWorkExperienceMapperServiceImpl implements EmployeeWorkExperienceMapperService {

    private final WorkExperienceMapperService mapperService;
    @Override
    public WorkExperienceResponse toDTO(EmployeeWorkExperience workExperience) {
        return mapperService.toDTO(workExperience);
    }

    @Override
    public EmployeeWorkExperience toEntity(WorkExperienceRequest dto) {
        return (EmployeeWorkExperience) mapperService.toEntity(dto);
    }

    @Override
    public EmployeeWorkExperience toEntity(EmployeeWorkExperience workExperience, WorkExperienceRequest dto) {
        return (EmployeeWorkExperience) mapperService.toEntity(workExperience,dto);
    }

}
