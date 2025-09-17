package com.fractal.domain.employee_management.insurance.dto;

import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.insurance.coverage.InsuranceCoverage;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.type.InsuranceType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
