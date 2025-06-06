package com.fractal.domain.employee_management.citizenship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CitizenshipRepository extends JpaRepository<Citizenship,Long> {
}
