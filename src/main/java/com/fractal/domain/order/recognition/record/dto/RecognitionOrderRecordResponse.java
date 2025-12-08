package com.fractal.domain.order.recognition.record.dto;

import com.fractal.domain.employment.dto.EmploymentResponse;

import java.time.LocalDateTime;

public record RecognitionOrderRecordResponse(
        Long id,
        EmploymentResponse employment,
        LocalDateTime createdDate

) {
}
