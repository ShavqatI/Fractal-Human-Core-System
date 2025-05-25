package com.fractal.domain.employee_management.performance.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface PerformanceTypeRepository extends JpaRepository<PerformanceType,Long> {
    Optional<PerformanceType> findById(Long id);
    Optional<PerformanceType> findByCode(String code);
    List<PerformanceType> findAll();
}
