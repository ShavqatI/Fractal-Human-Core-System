package com.fractal.domain.employee_management.employment.dto;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmploymentHistoryResponse(
        Long id,
        String orderNumber,
        LocalDate orderDate,
        Integer serial,
        LocalDate startDate,
        LocalDate endDate,
        String organization,
        String department,
        String position,
        String employmentType,
        String status,
        List<AgreementResponse> agreements,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
