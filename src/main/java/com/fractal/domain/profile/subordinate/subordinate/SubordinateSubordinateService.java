package com.fractal.domain.profile.subordinate.subordinate;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.subordinate.Subordinate;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;

import java.util.List;

public interface SubordinateSubordinateService{
    List<Subordinate> getAll();
    List<Employee> getAllActiveEmployees();
    Subordinate getById(Long id);
    SubordinateResponse toDTO(Subordinate subordinate);

}
