package com.fractal.domain.organization_management.grade.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface GradeEvaluationRepository extends JpaRepository<GradeEvaluation, Long> {
    List<GradeEvaluation> findAllByGradeId(Long gradeId);
    Optional<GradeEvaluation> findByGradeIdAndId(Long gradeId, Long id);
}
