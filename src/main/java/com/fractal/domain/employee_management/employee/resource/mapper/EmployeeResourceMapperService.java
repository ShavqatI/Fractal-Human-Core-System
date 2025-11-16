package com.fractal.domain.employee_management.employee.resource.mapper;

import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;
import com.fractal.domain.recruitment.candidate.resource.CandidateResource;

public interface EmployeeResourceMapperService {
    EmployeeResourceResponse toDTO(EmployeeResource resource);

    EmployeeResource copy(CandidateResource resource);

    EmployeeResource toEntity(EmployeeResourceRequest dto, String resourceStoragePath);

    EmployeeResource toEntity(EmployeeResource resource, EmployeeResourceRequest dto, String resourceStoragePath);


}


