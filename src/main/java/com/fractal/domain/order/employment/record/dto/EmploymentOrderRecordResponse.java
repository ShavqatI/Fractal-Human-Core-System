package com.fractal.domain.order.employment.record.dto;

import com.fractal.domain.employment.dto.EmploymentResponse;

import java.time.LocalDateTime;

public record EmploymentOrderRecordResponse(
        Long id,
        EmploymentResponse employment,
        LocalDateTime createdDate

) {
}
