package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.dictionary.currency.dto.CurrencyResponse;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record GradeResponse(
        Long id,
        String code,
        String name,
        CurrencyResponse currency,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        StatusResponse statusId,
        String notes,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
