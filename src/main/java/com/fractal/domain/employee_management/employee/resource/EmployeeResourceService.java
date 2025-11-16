package com.fractal.domain.employee_management.employee.resource;

import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceRequest;
import com.fractal.domain.employee_management.employee.resource.dto.EmployeeResourceResponse;

import java.util.List;

public interface EmployeeResourceService {

    EmployeeResource create(Long employeeId, EmployeeResourceRequest dto);

    List<EmployeeResource> getAllByEmployeeId(Long employeeId);

    EmployeeResource getById(Long employeeId, Long id);

    EmployeeResource update(Long employeeId, Long id, EmployeeResourceRequest dto);

    void delete(Long employeeId, Long id);

    EmployeeResourceResponse toDTO(EmployeeResource resource);

}
