package com.fractal.domain.finance.currency.dto;

import com.fractal.domain.location.country.dto.CountryResponse;

import java.time.LocalDateTime;

public record CurrencyResponse(
        Long id,
        String code,
        Integer numericCode,
        String name,
        CountryResponse country,
        LocalDateTime createdDate

) {

}
