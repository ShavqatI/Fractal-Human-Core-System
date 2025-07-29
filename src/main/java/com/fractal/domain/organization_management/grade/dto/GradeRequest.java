package com.fractal.domain.organization_management.grade.dto;

import com.fractal.domain.dictionary.currency.Currency;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderRequest;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record GradeRequest(
        String code,
        String name,
        Long currencyId,
        BigDecimal minSalary,
        BigDecimal  maxSalary,
        LocalDate startDate,
        LocalDate endDate,
        Long statusId,
        String notes
) {
}
