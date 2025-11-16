package com.fractal.domain.finance.expense.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {
    Optional<ExpenseType> findByCode(String code);

}
