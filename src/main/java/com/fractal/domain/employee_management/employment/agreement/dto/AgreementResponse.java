package com.fractal.domain.employee_management.employment.agreement.dto;

import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record AgreementResponse(
        Long id,
        String number,
        LocalDate startDate,
        LocalDate endDate,
        String status,

        List<ResourceResponse> resources,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
