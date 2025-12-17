package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;

public interface EmployeeEmploymentApprovedMapperService {
    InternalEmploymentApprovedResponse toDTO(EmployeeEmployment employment);
    }


