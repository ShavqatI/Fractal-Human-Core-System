package com.fractal.domain.organization_management.grade.benchmarking.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface BenchmarkingTypeRepository extends JpaRepository<BenchmarkingType, Long> {
    Optional<BenchmarkingType> findById(Long id);

    Optional<BenchmarkingType> findByCode(String code);

    List<BenchmarkingType> findAll();
}
