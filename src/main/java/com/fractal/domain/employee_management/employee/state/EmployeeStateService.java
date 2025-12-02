package com.fractal.domain.employee_management.employee.state;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.order.Order;

import java.util.List;

public interface EmployeeStateService {
    EmployeeState create(Employee employee);

    List<EmployeeState> getAll();

    EmployeeState getById(Long id);

    List<EmployeeState> getAllByEmployeeId(Long employeeId);

    EmployeeState update(Long id, Employee employee);

    void deleteById(Long id);

    EmployeeStateResponse toDTO(EmployeeState state);

    EmployeeState save(EmployeeState state);
}
