package com.fractal.domain.organization_management.grade.band;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface GradeSalaryBandRepository extends JpaRepository<GradeSalaryBand, Long> {
    List<GradeSalaryBand> findAllByGradeId(Long gradeId);
    Optional<GradeSalaryBand> findByGradeIdAndId(Long gradeId, Long id);
}
