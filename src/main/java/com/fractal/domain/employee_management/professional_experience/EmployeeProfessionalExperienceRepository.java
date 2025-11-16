package com.fractal.domain.employee_management.professional_experience;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeProfessionalExperienceRepository extends JpaRepository<EmployeeProfessionalExperience, Long> {

    List<EmployeeProfessionalExperience> findAllByEmployeeId(Long employeeId);

    Optional<EmployeeProfessionalExperience> findByEmployeeIdAndId(Long employeeId, Long id);
}
