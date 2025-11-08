package com.fractal.domain.employment.docuemnt_template_manager.dto;

import java.time.LocalDateTime;

public record PaymentFrequencyResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
