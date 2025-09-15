package com.fractal.domain.employee_management.business_trip.expense.type;

import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeRequest;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeCompactResponse;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeResponse;

import java.util.List;

public interface BusinessTripExpenseTypeService {

    BusinessTripExpenseType create(BusinessTripExpenseTypeRequest dto);
    List<BusinessTripExpenseType> getAll();
    BusinessTripExpenseType getByCode(String code);
    BusinessTripExpenseType getById(Long id);
    BusinessTripExpenseType update(Long id, BusinessTripExpenseTypeRequest dto);
    void deleteById(Long id);
    BusinessTripExpenseTypeResponse toDTO(BusinessTripExpenseType businessTripExpenseType);
    BusinessTripExpenseTypeCompactResponse toCompactDTO(BusinessTripExpenseType businessTripExpenseType);
}
