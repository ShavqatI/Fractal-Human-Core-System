package com.fractal.domain.integration.mapping.employee;

import com.fractal.domain.integration.mapping.employee.dto.EmployeeMappingRequest;
import com.fractal.domain.integration.mapping.employee.dto.EmployeeMappingResponse;

import java.util.List;

public interface EmployeeMappingService {

    EmployeeMapping create(EmployeeMappingRequest dto);

    List<EmployeeMapping> getAll();

    EmployeeMapping getById(Long id);

    EmployeeMapping update(Long id, EmployeeMappingRequest dto);

    void deleteById(Long id);

    EmployeeMappingResponse toDTO(EmployeeMapping employeeMapping);
}
