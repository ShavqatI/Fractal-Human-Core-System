package com.fractal.domain.employee_management.education.mapper;

import com.fractal.domain.education.Education;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employee_management.education.EmployeeEducation;


public interface EmployeeEducationMapperService {
    EducationResponse toDTO(EmployeeEducation education);
    EmployeeEducation toEntity(EducationRequest dto);
    EmployeeEducation toEntity(EmployeeEducation education, EducationRequest dto);
    EmployeeEducation convert(EmployeeEducation employeeEducation, Education education);
    EmployeeEducation copy(Education education);
}


