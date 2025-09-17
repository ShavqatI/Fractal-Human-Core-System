package com.fractal.domain.employee_management.insurance.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageResponse;
import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.provider.dto.InsuranceProviderCompactResponse;
import com.fractal.domain.insurance.type.dto.InsuranceTypeResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InsuranceResponse(
        Long id,
        EmployeeCompactResponse employee,
        InsuranceTypeResponse insuranceType,
        InsuranceProviderCompactResponse insuranceProvider,
        String policyNumber,
        LocalDate startDate,
        LocalDate endDate,
        List<InsuranceCoverageResponse> coverages,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {
}
