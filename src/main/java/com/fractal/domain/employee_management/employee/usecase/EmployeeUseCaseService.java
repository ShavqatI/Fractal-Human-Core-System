package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;

import java.util.Optional;

public interface EmployeeUseCaseService {

    String getFullName(Employee employee);
    String getLastNameWithInitials(Employee employee);
    Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee);
}
