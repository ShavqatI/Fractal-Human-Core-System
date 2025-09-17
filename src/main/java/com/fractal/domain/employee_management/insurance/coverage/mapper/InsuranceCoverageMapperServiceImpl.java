package com.fractal.domain.employee_management.insurance.coverage.mapper;

import com.fractal.domain.employee_management.insurance.coverage.InsuranceCoverage;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InsuranceCoverageMapperServiceImpl implements InsuranceCoverageMapperService {


    @Override
    public InsuranceCoverageResponse toDTO(InsuranceCoverage coverage) {
        return new InsuranceCoverageResponse(
                   coverage.getId(),
                   coverage.getDescription(),
                   coverage.getAmount(),
                   coverage.getCreatedDate()

        );
    }

    @Override
    public InsuranceCoverage toEntity(InsuranceCoverageRequest dto) {
        return mapToEntity(new InsuranceCoverage(),dto);
    }

    @Override
    public InsuranceCoverage toEntity(InsuranceCoverage coverage, InsuranceCoverageRequest dto) {
        return mapToEntity(coverage,dto);
    }

    private InsuranceCoverage mapToEntity(InsuranceCoverage coverage, InsuranceCoverageRequest dto) {
        coverage.setDescription(dto.description());
        coverage.setAmount(dto.amount());
        return coverage;
    }

}
