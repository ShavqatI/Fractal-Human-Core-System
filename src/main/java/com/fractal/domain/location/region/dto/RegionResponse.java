package com.fractal.domain.location.region.dto;

import com.fractal.domain.location.country.dto.CountryResponse;

import java.time.LocalDateTime;

public record RegionResponse(
        Long id,
        String code,
        String name,
        CountryResponse country,
        LocalDateTime createdDate
) { }
