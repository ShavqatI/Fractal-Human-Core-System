package com.fractal.domain.location.region.dto;

import java.time.LocalDateTime;

public record RegionResponse(
        Long id,
        String code,
        String name,
        String country,
        LocalDateTime createdDate
) { }
