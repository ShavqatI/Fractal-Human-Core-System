package com.fractal.domain.order.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
class OrderUseCaseServiceImpl implements OrderUseCaseService {

    private final InternalEmploymentService employmentService;
    private final EmployeeEmploymentUseCaseService employeeEmploymentUseCaseService;
    @Override
    public Map getHeader(Order order) {
        Map<String,String> values = new HashMap<>();
        values.put("number",order.getNumber());
        values.put("docDate", order.getDate().toString());
        return values;
    }
    @Override
    public Map getFooter() {
        Map<String,String> values = new HashMap<>();
        values.put("hrHead",employeeEmploymentUseCaseService.getHrHeadEmployeeName());
        return values;
    }


}
