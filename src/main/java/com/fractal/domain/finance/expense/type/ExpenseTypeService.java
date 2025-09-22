package com.fractal.domain.finance.expense.type;

import com.fractal.domain.finance.expense.type.dto.ExpenseTypeCompactResponse;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeRequest;
import com.fractal.domain.finance.expense.type.dto.ExpenseTypeResponse;

import java.util.List;

public interface ExpenseTypeService {

    ExpenseType create(ExpenseTypeRequest dto);
    List<ExpenseType> getAll();
    ExpenseType getByCode(String code);
    ExpenseType getById(Long id);
    ExpenseType update(Long id, ExpenseTypeRequest dto);
    void deleteById(Long id);
    ExpenseTypeResponse toDTO(ExpenseType expenseType);
    ExpenseTypeCompactResponse toCompactDTO(ExpenseType expenseType);
}
