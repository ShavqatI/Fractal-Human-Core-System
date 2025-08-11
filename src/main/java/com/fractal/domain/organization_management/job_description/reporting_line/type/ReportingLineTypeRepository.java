package com.fractal.domain.organization_management.job_description.reporting_line.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface ReportingLineTypeRepository extends JpaRepository<ReportingLineType,Long> {
    Optional<ReportingLineType> findById(Long id);
    Optional<ReportingLineType> findByCode(String code);
    List<ReportingLineType> findAll();
}
