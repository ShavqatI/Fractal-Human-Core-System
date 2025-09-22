package com.fractal.domain.finance.expense.type.category;

import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryRequest;
import com.fractal.domain.finance.expense.type.category.dto.ExpenseTypeCategoryResponse;

import java.util.List;

public interface ExpenseTypeCategoryService {

    ExpenseTypeCategory create(ExpenseTypeCategoryRequest dto);
    List<ExpenseTypeCategory> getAll();
    ExpenseTypeCategory getByCode(String code);
    ExpenseTypeCategory getById(Long id);
    ExpenseTypeCategory update(Long id, ExpenseTypeCategoryRequest dto);
    void deleteById(Long id);
    ExpenseTypeCategoryResponse toDTO(ExpenseTypeCategory expenseTypeCategory);
}
