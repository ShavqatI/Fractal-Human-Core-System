package com.fractal.domain.employee_management.business_trip.expense.mapper;

import com.fractal.domain.employee_management.business_trip.expense.BusinessTripExpense;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;

public interface BusinessTripExpenseMapperService {
    BusinessTripExpenseResponse toDTO(BusinessTripExpense order);
    BusinessTripExpense toEntity(BusinessTripExpenseRequest dto);
    BusinessTripExpense toEntity(BusinessTripExpense order, BusinessTripExpenseRequest dto);
}


