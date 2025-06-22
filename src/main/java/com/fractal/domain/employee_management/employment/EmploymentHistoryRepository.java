package com.fractal.domain.employee_management.employment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory,Long> {

    List<EmploymentHistory> findAllByEmployeeId(Long employeeId);
    Optional<EmploymentHistory> findByEmployeeIdAndId(Long employeeId, Long id);

}
