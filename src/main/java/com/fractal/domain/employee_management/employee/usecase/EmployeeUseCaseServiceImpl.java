package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeUseCaseServiceImpl implements EmployeeUseCaseService {
    @Override
    public String getFullName(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getLastName() + " ");
        sb.append(employee.getFirstName()+ " ");
        sb.append(employee.getPatronymicName());
        return sb.toString();
    }
}
