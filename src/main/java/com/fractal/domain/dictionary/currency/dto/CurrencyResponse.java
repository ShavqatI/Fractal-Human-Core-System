package com.fractal.domain.dictionary.currency.dto;

import java.time.LocalDateTime;

public record CurrencyResponse(
        Long id,
        String code,
        Integer numericCode,
        String name,
        String country,
        LocalDateTime createdDate

) {

}
