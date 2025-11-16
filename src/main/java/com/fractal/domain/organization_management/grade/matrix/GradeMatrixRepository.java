package com.fractal.domain.organization_management.grade.matrix;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface GradeMatrixRepository extends JpaRepository<GradeMatrix, Long> {
    List<GradeMatrix> findAllByGradeId(Long gradeId);

    Optional<GradeMatrix> findByGradeIdAndId(Long gradeId, Long id);
}
