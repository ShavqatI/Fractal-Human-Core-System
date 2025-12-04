package com.fractal.domain.order.bonus.record.dto;

import com.fractal.domain.employment.dto.EmploymentResponse;

import java.time.LocalDateTime;

public record BonusOrderRecordResponse(
        Long id,
        EmploymentResponse employment,
        LocalDateTime createdDate

) {
}
