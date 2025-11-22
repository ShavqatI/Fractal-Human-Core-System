package com.fractal.domain.vacation_management.vacation.allocation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationAllocationRepository extends JpaRepository<VacationAllocation, Long> {

    List<VacationAllocation> findAllByVacationRequestId(Long vacationRequestId);

    Optional<VacationAllocation> findByVacationRequestIdAndId(Long vacationRequestId, Long id);
}
