package com.fractal.domain.dictionary.currency.dto;

import java.time.LocalDateTime;

public record CurrencyCompactResponse(
        Long id,
        String code,
        Integer numericCode,
        String name) {

}
