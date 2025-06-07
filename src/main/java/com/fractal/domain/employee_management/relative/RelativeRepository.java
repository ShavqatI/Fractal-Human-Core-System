package com.fractal.domain.employee_management.relative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RelativeRepository extends JpaRepository<Relative,Long> {
}
