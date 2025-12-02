package com.fractal.domain.employee_management.employment.state;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;

import java.util.List;

public interface EmployeeEmploymentStateService  {
    EmployeeEmploymentState create(EmployeeEmployment employeeEmployment);

    List<EmployeeEmploymentState> getAll();

    EmployeeEmploymentState getById(Long id);

    List<EmployeeEmploymentState> getAllByEmployeeEmploymentId(Long employeeId);

    EmployeeEmploymentState update(Long id, EmployeeEmployment employeeEmployment);

    void deleteById(Long id);

    EmployeeEmploymentStateResponse toDTO(EmployeeEmploymentState state);

    EmployeeEmploymentState save(EmployeeEmploymentState state);
}
