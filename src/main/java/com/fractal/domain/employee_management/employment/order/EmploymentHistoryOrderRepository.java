package com.fractal.domain.employee_management.employment.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmploymentHistoryOrderRepository extends JpaRepository<EmploymentHistoryOrder,Long> {

    List<EmploymentHistoryOrder> findAllByEmploymentHistoryId(Long employmentHistoryId);
    Optional<EmploymentHistoryOrder> findByEmploymentHistoryIdAndId(Long employmentHistoryId, Long id);
}
