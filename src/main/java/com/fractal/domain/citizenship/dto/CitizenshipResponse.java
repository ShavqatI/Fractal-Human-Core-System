package com.fractal.domain.citizenship.dto;

import com.fractal.domain.location.country.dto.CountryCompactResponse;

import java.time.LocalDateTime;

public record CitizenshipResponse(
        Long id,
        CountryCompactResponse country,
        LocalDateTime createdDate
) {
}
