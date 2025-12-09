package com.fractal.domain.employee_management.employee;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeRequest;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.order.vacation.VacationOrder;

import java.util.List;

public interface EmployeeService extends ApprovalWorkflowAware<Long, Employee> {
    Employee create(EmployeeRequest dto);

    List<Employee> getAll();

    Employee getByTin(String tin);

    Employee getById(Long id);

    Employee update(Long id, EmployeeRequest dto);

    void deleteById(Long id);

    EmployeeResponse toDTO(Employee employee);

    EmployeeCompactResponse toCompactDTO(Employee employee);

    Employee save(Employee employee);
    void activate(Long id);
    Employee getByUUID(String uuid);
}
