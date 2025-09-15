package com.fractal.domain.employee_management.business_trip.expense.type.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;

import java.time.LocalDateTime;
import java.util.List;

public record BusinessTripExpenseTypeResponse(
        Long id,
        String code,
        String name,
        String parent,
        List<BusinessTripExpenseTypeResponse> children,
        StatusCompactResponse status,
        LocalDateTime createdDate
) {}
