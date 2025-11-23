package com.fractal.domain.employee_management.employee.usecase;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class EmployeeUseCaseServiceImpl implements EmployeeUseCaseService {
    private final EmployeeEmploymentService employeeEmploymentService;
    private final InternalEmploymentService internalEmploymentService;
    private final EmploymentService employmentService;
    private final StatusService statusService;
    @Override
    public String getFullName(Employee employee) {
        StringBuilder sb = new StringBuilder();
        if(employee != null) {
            sb.append(employee.getLastName() + " ");
            sb.append(employee.getFirstName() + " ");
            sb.append(employee.getPatronymicName());
        }
        return sb.toString();
    }

    @Override
    public String getLastNameWithInitials(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getLastName()).append(" ");
        sb.append(employee.getFirstName().substring(0,1)).append(". ");
        sb.append(employee.getPatronymicName().substring(0,1)).append(".");
        return sb.toString();
    }

    @Override
    public Optional<InternalEmploymentResponse> getCurrentEmployment(Employee employee) {
        List<EmployeeEmployment> employeeEmployments = employeeEmploymentService.getAllByEmployeeId(employee.getId());
        var response = employeeEmployments.stream().map(employeeEmployment -> (EmployeeEmployment) Hibernate.unproxy(employeeEmployment))
                .map(employeeEmployment -> employmentService.getById(employeeEmployment.getEmployment().getId()) )
                .map(employment -> (Employment) Hibernate.unproxy(employment))
                .filter(employment -> employment.getEndDate() == null
                                && statusService.getById(employment.getStatus().getId()).getCode().equals("ACTIVE")
                                && employment instanceof InternalEmployment
                ).findFirst().map(employment-> internalEmploymentService.toDTO((InternalEmployment) employment));
        return response;
    }
}
