package com.fractal.domain.employee_management.insurance.coverage.mapper;

import com.fractal.domain.employee_management.insurance.coverage.InsuranceCoverage;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageResponse;

public interface InsuranceCoverageMapperService {
    InsuranceCoverageResponse toDTO(InsuranceCoverage coverage);

    InsuranceCoverage toEntity(InsuranceCoverageRequest dto);

    InsuranceCoverage toEntity(InsuranceCoverage coverage, InsuranceCoverageRequest dto);
}


