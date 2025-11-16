package com.fractal.domain.location.country.dto;

import java.time.LocalDateTime;

public record CountryResponse(
        Long id,
        String code,
        String name,
        String iso3Code,
        String numericCode,
        String phonePrefix,
        LocalDateTime createdDate

) {
}
