package com.fractal.domain.organization_management.grade.step;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface GradeStepRepository extends JpaRepository<GradeStep, Long> {
    List<GradeStep> findAllByGradeId(Long gradeId);
    Optional<GradeStep> findByGradeIdAndId(Long gradeId, Long id);
}
