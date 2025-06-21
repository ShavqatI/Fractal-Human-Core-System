package com.fractal.domain.employee_management.education.mapper;

import com.fractal.domain.employee_management.education.Education;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.education.dto.EducationResponse;

public interface EducationMapperService {
    EducationResponse toDTO(Education education);
    Education toEntity(EducationRequest dto);
    Education toEntity(Education education, EducationRequest dto);
}


