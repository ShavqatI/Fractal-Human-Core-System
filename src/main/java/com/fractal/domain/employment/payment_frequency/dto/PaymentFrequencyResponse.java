package com.fractal.domain.employment.payment_frequency.dto;

import java.time.LocalDateTime;

public record PaymentFrequencyResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
