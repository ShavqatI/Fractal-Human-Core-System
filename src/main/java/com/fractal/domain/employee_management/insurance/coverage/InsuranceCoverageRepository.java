package com.fractal.domain.employee_management.insurance.coverage;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceCoverageRepository extends JpaRepository<InsuranceCoverage, Long> {

    List<InsuranceCoverage> findAllByInsuranceId(Long insuranceId);

    Optional<InsuranceCoverage> findByInsuranceIdAndId(Long insuranceId, Long id);
}
