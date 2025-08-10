package com.fractal.domain.dictionary.currency.dto;

public record CurrencyCompactResponse(
        Long id,
        String code,
        Integer numericCode,
        String name) {

}
