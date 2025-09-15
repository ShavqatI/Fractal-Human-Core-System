package com.fractal.domain.employee_management.language_skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmployeeLanguageSkillRepository extends JpaRepository<EmployeeLanguageSkill,Long> {

    List<EmployeeLanguageSkill> findAllByEmployeeId(Long employeeId);
    Optional<EmployeeLanguageSkill> findByEmployeeIdAndId(Long employeeId, Long id);
}
