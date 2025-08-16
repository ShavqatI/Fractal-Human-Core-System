package com.fractal.domain.employee_management.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation,Long> {
    List<EmployeeEducation> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeEducation> findByEmployeeIdAndId(Long employeeId, Long id);
}
