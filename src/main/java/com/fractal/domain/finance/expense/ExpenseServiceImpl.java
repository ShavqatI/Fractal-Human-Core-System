package com.fractal.domain.finance.expense;

import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    @Override
    public Expense getById(Long id) {
        return expenseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EBusiness Trip Expense with id:" + id + " not found"));
    }

    @Override
    public Expense save(Expense expense) {
        try {
            return expenseRepository.save(expense);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

}
