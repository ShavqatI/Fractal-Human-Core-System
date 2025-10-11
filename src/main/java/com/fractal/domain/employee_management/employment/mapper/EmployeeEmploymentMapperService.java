package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.dto.EmploymentRequest;
import com.fractal.domain.employment.dto.EmploymentResponse;

public interface EmployeeEmploymentMapperService {
    EmploymentResponse toDTO(EmployeeEmployment employment);
    EmployeeEmployment toEntity(EmploymentRequest dto);
    EmployeeEmployment toEntity(EmployeeEmployment employment, EmploymentRequest dto);
}


