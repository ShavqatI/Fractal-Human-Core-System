package com.fractal.domain.order.employment.record.dto;

import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;

import java.time.LocalDateTime;

public record InternalEmploymentOrderRecordResponse(
        Long id,
        InternalEmploymentResponse employment,
        LocalDateTime createdDate

) {
}
