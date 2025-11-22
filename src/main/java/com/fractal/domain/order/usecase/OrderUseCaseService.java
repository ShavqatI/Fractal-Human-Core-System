package com.fractal.domain.order.usecase;

import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.order.Order;

import java.util.Map;

public interface OrderUseCaseService {

     Map getHeader(Order order);
     Map getFooter();

}
