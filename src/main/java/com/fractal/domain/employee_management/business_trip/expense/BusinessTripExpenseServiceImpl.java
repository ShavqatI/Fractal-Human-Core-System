package com.fractal.domain.employee_management.business_trip.expense;

import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;
import com.fractal.domain.employee_management.business_trip.expense.mapper.BusinessTripExpenseMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripExpenseServiceImpl implements BusinessTripExpenseService {

    private final BusinessTripExpenseRepository expenseRepository;
    private final BusinessTripExpenseMapperService expenseMapperService;
    private final BusinessTripService businessTripService;


    @Override
    @Transactional
    public BusinessTripExpense create(Long businessTripId, BusinessTripExpenseRequest dto) {
        var businessTrip = businessTripService.getById(businessTripId);
        var expense = expenseMapperService.toEntity(dto);
        businessTrip.addExpense(expense);
        businessTripService.save(businessTrip);
        return expense;
    }

    @Override
    public List<BusinessTripExpense> getAllByBusinessTripId(Long businessTripId) {
        return expenseRepository.findAllByBusinessTripId(businessTripId);
    }

    @Override
    public BusinessTripExpense getById(Long businessTripId, Long id) {
        return expenseRepository.findByBusinessTripIdAndId(businessTripId,id).orElseThrow(()-> new ResourceNotFoundException("Business Trip Expense with id:" + id + " not found"));
    }

    @Override
    public BusinessTripExpense getById(Long id) {
        return expenseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EBusiness Trip Expense with id:" + id + " not found"));
    }

    @Override
    @Transactional
    public BusinessTripExpense update(Long businessTripId, Long id, BusinessTripExpenseRequest dto) {
        var businessTrip = businessTripService.getById(businessTripId);
        var expense = businessTrip.getExpenses()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Expense with id: " + id + " not found"));
        expense = expenseMapperService.toEntity(expense,dto);
        businessTripService.save(businessTrip);
        return expense;
    }

    @Override
    @Transactional
    public void delete(Long businessTripId, Long id) {
        var businessTrip = businessTripService.getById(businessTripId);
        var expense = businessTrip.getExpenses()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("EBusiness Trip Expense with id: " + id + " not found"));
        businessTrip.removeExpense(expense);
        businessTripService.save(businessTrip);
    }

    @Override
    public BusinessTripExpenseResponse toDTO(BusinessTripExpense order) {
        return expenseMapperService.toDTO(order);
    }

    @Override
    public BusinessTripExpense save(BusinessTripExpense expense) {
        try {
            return expenseRepository.save(expense);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

}
