package com.fractal.domain.organization_management.grade.level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface GradeLevelRepository extends JpaRepository<GradeLevel,Long> {
    Optional<GradeLevel> findById(Long id);
    Optional<GradeLevel> findByCode(String code);
    List<GradeLevel> findAll();
}
