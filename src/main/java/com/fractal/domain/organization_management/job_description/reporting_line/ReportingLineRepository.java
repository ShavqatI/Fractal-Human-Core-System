package com.fractal.domain.organization_management.job_description.reporting_line;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportingLineRepository extends JpaRepository<ReportingLine, Long> {

    List<ReportingLine> findAllByJobDescriptionId(Long jobDescriptionId);

    Optional<ReportingLine> findByJobDescriptionIdAndId(Long jobDescriptionId, Long id);
}
