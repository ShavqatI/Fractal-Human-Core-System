package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.internal.InternalEmployment;

import java.util.Optional;

public interface EmployeeUseCaseService {

    String getFullName(Employee employee);
    Optional<InternalEmployment> getCurrentEmployment(Employee employee);
}
