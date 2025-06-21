package com.fractal.domain.employee_management.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EducationRepository extends JpaRepository<Education,Long> {
    List<Education> findAllByEmployeeId(Long employeeId);
    Optional<Education> findByEmployeeIdAndId(Long employeeId,Long id);
}
