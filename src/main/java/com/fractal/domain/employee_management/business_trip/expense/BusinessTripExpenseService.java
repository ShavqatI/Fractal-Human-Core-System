package com.fractal.domain.employee_management.business_trip.expense;

import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;

import java.util.List;

public interface BusinessTripExpenseService {

    BusinessTripExpense create(Long businessTripId, BusinessTripExpenseRequest dto);

    List<BusinessTripExpense> getAllByBusinessTripId(Long businessTripId);

    BusinessTripExpense getById(Long businessTripId, Long id);

    BusinessTripExpense getById(Long id);

    BusinessTripExpense update(Long businessTripId, Long id, BusinessTripExpenseRequest dto);

    void delete(Long businessTripId, Long id);

    BusinessTripExpenseResponse toDTO(BusinessTripExpense businessTripExpense);

    BusinessTripExpense save(BusinessTripExpense expense);

}
