package com.fractal.domain.finance.expense.type.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ExpenseTypeCategoryRepository extends JpaRepository<ExpenseTypeCategory,Long> {
    Optional<ExpenseTypeCategory> findById(Long id);
    Optional<ExpenseTypeCategory> findByCode(String code);
    List<ExpenseTypeCategory> findAll();
}
