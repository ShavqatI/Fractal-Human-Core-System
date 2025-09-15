package com.fractal.domain.employee_management.business_trip.expense.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessTripExpenseResourceRepository extends JpaRepository<BusinessTripExpenseResource,Long> {

    List<BusinessTripExpenseResource> findAllByBusinessTripExpenseId(Long businessTripExpenseId);
    Optional<BusinessTripExpenseResource> findByByBusinessTripExpenseIdAndId(Long businessTripExpenseId, Long id);

}
