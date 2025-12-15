package com.fractal.domain.employee_management.employment.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.HireRequest;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.organization_management.position.Position;

import java.util.Optional;

public interface EmployeeEmploymentUseCaseService {

    Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee);
    Employee getHrHeadEmployee();
    Employee getCEOEmployee();
    Employee getSupervisorEmployee(Position position);
    InternalEmployment copy(InternalEmployment employment);


}
