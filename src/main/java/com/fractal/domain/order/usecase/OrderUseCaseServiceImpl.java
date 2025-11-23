package com.fractal.domain.order.usecase;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.authorization.mapping.user_employee.UserEmployeeMappingService;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class OrderUseCaseServiceImpl implements OrderUseCaseService {

    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;
    private final UserEmployeeMappingService userEmployeeMappingService;
    private final AuthenticatedService authenticatedService;
    private final EmployeeUseCaseService employeeUseCaseService;
    @Override
    public Map getHeader(Order order) {
        Map<String,String> values = new HashMap<>();
        values.put("number",order.getNumber());
        values.put("docDate", order.getDate().toString());
        getCurrentUserEmployeeEmployment().ifPresent(employment-> values.put("branchName",employment.organization().name()));
        return values;
    }
    @Override
    public Map getFooter() {
        Map<String,String> values = new HashMap<>();
        values.put("hrHead",employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getHrHeadEmployee()));
        return values;
    }

    private Optional<InternalEmploymentResponse> getCurrentUserEmployeeEmployment() {
        var employee = userEmployeeMappingService.getEmployee(authenticatedService.getUser());
        return employeeUseCaseService.getCurrentEmployment(employee);
    }

    @Override
    public String getCEO() {
       return employeeUseCaseService.getLastNameWithInitials(employeeEmploymentUseCaseService.getCEOEmployee());
    }


}
