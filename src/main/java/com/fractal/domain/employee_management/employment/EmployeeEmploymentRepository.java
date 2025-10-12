package com.fractal.domain.employee_management.employment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeEmploymentRepository extends JpaRepository<EmployeeEmployment, Long> {
    List<EmployeeEmployment> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeEmployment> findByEmployeeIdAndId(Long employeeId, Long id);
}
