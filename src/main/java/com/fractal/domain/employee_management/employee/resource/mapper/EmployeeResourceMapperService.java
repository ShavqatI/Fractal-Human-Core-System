package com.fractal.domain.employee_management.employee.resource.mapper;

import com.fractal.domain.employee_management.employee.resource.EmployeeResource;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;

public interface EmployeeResourceMapperService {
    EmployeeResourceResponse toDTO(EmployeeResource resource);
    EmployeeResource toEntity(EmployeeResourceRequest dto, String url);
    EmployeeResource toEntity(EmployeeResource resource, EmployeeResourceRequest dto,String url);

}


