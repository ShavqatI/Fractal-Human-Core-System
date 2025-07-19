package com.fractal.domain.employee_management.employment.dto;

import com.fractal.domain.employee_management.business_trip.order.dto.BusinessTripOrderResponse;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.order.dto.EmploymentHistoryOrderResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record EmploymentHistoryResponse(
        Long id,
        Integer serial,
        LocalDate startDate,
        LocalDate endDate,
        String organization,
        String department,
        String position,
        String employmentType,
        String status,
        List<AgreementResponse> agreements,
        List<EmploymentHistoryOrderResponse> orders,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
