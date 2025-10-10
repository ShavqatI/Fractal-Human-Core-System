package com.fractal.domain.finance.currency.dto;

public record CurrencyCompactResponse(
        Long id,
        String code,
        Integer numericCode,
        String name) {

}
