package com.fractal.domain.employee_management.business_trip.expense.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BusinessTripExpenseTypeRepository extends JpaRepository<BusinessTripExpenseType,Long> {

    Optional<BusinessTripExpenseType> findByCode(String code);

}
