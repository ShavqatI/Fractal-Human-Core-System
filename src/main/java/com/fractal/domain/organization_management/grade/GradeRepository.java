package com.fractal.domain.organization_management.grade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface GradeRepository extends JpaRepository<Grade,Long> {
   Optional<Grade> findByCode(String code);
}
