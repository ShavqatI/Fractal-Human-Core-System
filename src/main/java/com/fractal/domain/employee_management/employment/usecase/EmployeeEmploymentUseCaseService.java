package com.fractal.domain.employee_management.employment.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;

import java.util.Optional;

public interface EmployeeEmploymentUseCaseService {

    Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee);
    Employee getHrHeadEmployee();
    Employee getCEOEmployee();
    void hire(Long employeeId, HireRequest dto);
}
