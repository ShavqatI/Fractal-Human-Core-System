package com.fractal.domain.finance.expense.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseResourceRepository extends JpaRepository<ExpenseResource, Long> {

    List<ExpenseResource> findAllByExpenseId(Long expenseId);

    Optional<ExpenseResource> findByExpenseIdAndId(Long expenseId, Long id);

}
