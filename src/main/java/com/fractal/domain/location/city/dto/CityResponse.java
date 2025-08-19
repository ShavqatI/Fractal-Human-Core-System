package com.fractal.domain.location.city.dto;

import com.fractal.domain.location.gender.dto.AreaTypeResponse;
import com.fractal.domain.location.region.dto.RegionResponse;

import java.time.LocalDateTime;

public record CityResponse(
        Long id,
        String code,
        String name,
        RegionResponse region,
        AreaTypeResponse areaType,
        LocalDateTime createdDate
) { }
