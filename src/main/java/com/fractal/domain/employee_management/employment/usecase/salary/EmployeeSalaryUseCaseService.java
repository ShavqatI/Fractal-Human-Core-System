package com.fractal.domain.employee_management.employment.usecase.salary;

import com.fractal.domain.employee_management.employment.usecase.salary.dto.SurchargeSalaryRequest;
import com.fractal.domain.employee_management.employment.usecase.salary.dto.DecreaseSalaryRequest;
import com.fractal.domain.employee_management.employment.usecase.salary.dto.IncreaseSalaryRequest;

public interface EmployeeSalaryUseCaseService {
    void increase(Long employeeId, IncreaseSalaryRequest dto);
    void decrease(Long employeeId, DecreaseSalaryRequest dto);
    void surcharge(Long employeeId, SurchargeSalaryRequest dto);
}
