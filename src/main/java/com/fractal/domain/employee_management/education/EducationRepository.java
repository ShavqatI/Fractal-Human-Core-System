package com.fractal.domain.employee_management.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EducationRepository extends JpaRepository<Education,Long> {
}
