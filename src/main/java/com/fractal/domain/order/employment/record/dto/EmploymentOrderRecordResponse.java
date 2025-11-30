package com.fractal.domain.order.employment.record.dto;

import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;

import java.time.LocalDateTime;

public record EmploymentOrderRecordResponse(
        Long id,
        EmploymentResponse employment,
        LocalDateTime createdDate

) {
}
