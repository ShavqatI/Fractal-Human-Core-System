package com.fractal.domain.organization_management.department.mapper;

import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;

public interface DepartmentMapperService {
    DepartmentResponse toDTO(Department department);

    DepartmentCompactResponse toCompactDTO(Department department);

    Department toEntity(DepartmentRequest dto);

    Department toEntity(Department department, DepartmentRequest dto);
}


