package com.fractal.domain.organization_management.grade.benchmarking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface BenchmarkingRepository extends JpaRepository<Benchmarking, Long> {
    List<Benchmarking> findAllByGradeId(Long gradeId);
    Optional<Benchmarking> findByGradeIdAndId(Long gradeId, Long id);
}
