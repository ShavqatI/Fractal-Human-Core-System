package com.fractal.domain.employee_management.employee;

import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeRequest dto);
    List<Employee> getAll();
    Employee getByTin(String tin);
    Employee getById(Long id);
    Employee update(Long id, EmployeeRequest dto);
    void deleteById(Long id);
    EmployeeResponse toDTO(Employee employee);
}
