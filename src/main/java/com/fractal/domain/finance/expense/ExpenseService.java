package com.fractal.domain.finance.expense;

public interface ExpenseService {
    Expense getById(Long id);

    Expense save(Expense expense);

}
