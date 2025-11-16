package com.fractal.domain.organization_management.job_description.kpi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeyPerformanceIndicatorRepository extends JpaRepository<KeyPerformanceIndicator, Long> {

    List<KeyPerformanceIndicator> findAllByJobDescriptionId(Long jobDescriptionId);

    Optional<KeyPerformanceIndicator> findByJobDescriptionIdAndId(Long jobDescriptionId, Long id);
}
