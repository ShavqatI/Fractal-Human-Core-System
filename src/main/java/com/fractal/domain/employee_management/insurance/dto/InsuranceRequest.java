package com.fractal.domain.employee_management.insurance.dto;

import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;

import java.time.LocalDate;
import java.util.List;

public record InsuranceRequest(
        Long employeeId,
        Long insuranceTypeId,
        Long insuranceProviderId,
        String policyNumber,
        LocalDate startDate,
        LocalDate endDate,
        List<InsuranceCoverageRequest> coverages,
        Long statusId


) {
}
