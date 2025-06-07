package com.fractal.domain.employee_management.military_service.dto;

import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record MilitaryServiceResponse(
         Long id,
         String accountNumber,
         String title,
         String categoryFund,
         String address,
         LocalDate beginDate,
         LocalDate endDate,
         List<ResourceResponse> resources,
         LocalDateTime createdDate
) {
}
