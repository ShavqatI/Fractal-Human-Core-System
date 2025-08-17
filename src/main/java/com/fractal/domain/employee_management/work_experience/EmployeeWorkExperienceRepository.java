package com.fractal.domain.employee_management.work_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeWorkExperienceRepository extends JpaRepository<EmployeeWorkExperience, Long> {
    List<EmployeeWorkExperience> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeWorkExperience> findByEmployeeIdAndId(Long employeeId, Long id);
}
