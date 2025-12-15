package com.fractal.domain.employee_management.employee.mapper;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;

public interface EmployeeMapperService {
    EmployeeResponse toDTO(Employee employee);

    Employee toEntity(EmployeeRequest dto);

    Employee toEntity(Employee employee, EmployeeRequest dto);

    EmployeeCompactResponse toCompactDTO(Employee employee);
    String getProfilePhoto(Employee employee);
}


