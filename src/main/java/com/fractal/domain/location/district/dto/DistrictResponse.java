package com.fractal.domain.location.district.dto;

import java.time.LocalDateTime;

public record DistrictResponse(
        Long id,
        String code,
        String name,
        String city,
        String region,
        LocalDateTime createdDate
) { }
