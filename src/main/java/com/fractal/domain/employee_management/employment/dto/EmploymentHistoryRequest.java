package com.fractal.domain.employee_management.employment.dto;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;

import java.time.LocalDate;
import java.util.List;

public record EmploymentHistoryRequest(
        String orderNumber,
        LocalDate orderDate,
        Integer serial,
        LocalDate startDate,
        LocalDate endDate,
        Long organizationId,
        Long departmentId,
        Long positionId,
        Long statusId,
        Long employmentTypeId,
        List<AgreementRequest> agreements
) {
}
