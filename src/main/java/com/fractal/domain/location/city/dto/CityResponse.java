package com.fractal.domain.location.city.dto;

import java.time.LocalDateTime;

public record CityResponse(
        Long id,
        String code,
        String name,
        String region,
        LocalDateTime createdDate
) { }
