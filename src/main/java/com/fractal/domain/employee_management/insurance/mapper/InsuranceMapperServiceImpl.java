package com.fractal.domain.employee_management.insurance.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.insurance.Insurance;
import com.fractal.domain.employee_management.insurance.coverage.mapper.InsuranceCoverageMapperService;
import com.fractal.domain.employee_management.insurance.dto.InsuranceRequest;
import com.fractal.domain.employee_management.insurance.dto.InsuranceResponse;
import com.fractal.domain.insurance.provider.InsuranceProviderService;
import com.fractal.domain.insurance.type.InsuranceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InsuranceMapperServiceImpl implements InsuranceMapperService {

    private final EmployeeService employeeService;
    private final InsuranceTypeService insuranceTypeService;
    private final InsuranceCoverageMapperService coverageMapperService;
    private final InsuranceProviderService insuranceProviderService;
    private final StatusService statusService;

    @Override
    public InsuranceResponse toDTO(Insurance insurance) {
        return new InsuranceResponse(
                   insurance.getId(),
                   null,
                   insuranceTypeService.toDTO(insurance.getInsuranceType()),
                   insuranceProviderService.toCompactDTO(insurance.getInsuranceProvider()),
                   insurance.getPolicyNumber(),
                   insurance.getStartDate(),
                   insurance.getEndDate(),
                   Optional.ofNullable(insurance.getCoverages())
                        .orElse(emptyList())
                        .stream()
                        .map(coverageMapperService::toDTO)
                        .collect(Collectors.toList()),
                   statusService.toCompactDTO(insurance.getStatus()),
                   insurance.getCreatedDate()

        );
    }

    @Override
    public Insurance toEntity(InsuranceRequest dto) {
        return mapToEntity(new Insurance(),dto);
    }

    @Override
    public Insurance toEntity(Insurance insurance, InsuranceRequest dto) {
        return mapToEntity(insurance,dto);
    }

    private Insurance mapToEntity(Insurance insurance, InsuranceRequest dto) {
        insurance.setEmployee(employeeService.getById(dto.employeeId()));
        insurance.setInsuranceType(insuranceTypeService.getById(dto.insuranceTypeId()));
        insurance.setInsuranceProvider(insuranceProviderService.getById(dto.insuranceProviderId()));
        insurance.setPolicyNumber(dto.policyNumber());
        insurance.setStartDate(dto.startDate());
        insurance.setEndDate(dto.endDate());
        insurance.setStatus(statusService.getById(dto.statusId()));
        dto.coverages().forEach(coverage-> insurance.addCoverage(coverageMapperService.toEntity(coverage)));
        return insurance;
    }

}
