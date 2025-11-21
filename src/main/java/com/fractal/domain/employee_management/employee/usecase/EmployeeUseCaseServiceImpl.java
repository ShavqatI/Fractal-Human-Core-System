package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.internal.InternalEmployment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

    @Override
    public Optional<InternalEmployment> getCurrentEmployment(Employee employee) {
       return employee.getEmployments().stream().filter(
                ee -> ee.getEmployment() instanceof InternalEmployment
                        && ee.getEmployment().getEndDate() == null
                        && ee.getEmployment().getStatus().getCode().equals("ACTIVE")
        ).map(ee-> (InternalEmployment) ee.getEmployment()).findFirst();
    }
}
