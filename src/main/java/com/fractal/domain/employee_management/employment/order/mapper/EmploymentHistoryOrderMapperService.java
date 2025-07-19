package com.fractal.domain.employee_management.employment.order.mapper;

import com.fractal.domain.employee_management.employment.order.EmploymentHistoryOrder;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderRequest;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;

public interface EmploymentHistoryOrderMapperService {
    EmploymentHistoryOrderResponse toDTO(EmploymentHistoryOrder order);
    EmploymentHistoryOrder toEntity(EmploymentHistoryOrderRequest dto);
    EmploymentHistoryOrder toEntity(EmploymentHistoryOrder order, EmploymentHistoryOrderRequest dto);
}


