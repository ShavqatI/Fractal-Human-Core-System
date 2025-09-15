package com.fractal.domain.employee_management.business_trip.expense;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessTripExpenseRepository extends JpaRepository<BusinessTripExpense,Long> {

    List<BusinessTripExpense> findAllByBusinessTripId(Long businessTrip);
    Optional<BusinessTripExpense> findByBusinessTripIdAndId(Long businessTrip, Long id);
}
