package com.fractal.domain.employee_management.insurance.coverage;

import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageResponse;

import java.util.List;

public interface InsuranceCoverageService {

    InsuranceCoverage create(Long insuranceId, InsuranceCoverageRequest dto);

    List<InsuranceCoverage> getAllByInsuranceId(Long insuranceId);

    InsuranceCoverage getById(Long insuranceId, Long id);

    InsuranceCoverage getById(Long id);

    InsuranceCoverage update(Long insuranceId, Long id, InsuranceCoverageRequest dto);

    void delete(Long insuranceId, Long id);

    InsuranceCoverageResponse toDTO(InsuranceCoverage coverage);

}
