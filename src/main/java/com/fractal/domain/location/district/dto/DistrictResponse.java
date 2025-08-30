package com.fractal.domain.location.district.dto;

import com.fractal.domain.location.area_type.dto.AreaTypeResponse;
import com.fractal.domain.location.city.dto.CityResponse;
import com.fractal.domain.location.region.dto.RegionResponse;

import java.time.LocalDateTime;

public record DistrictResponse(
        Long id,
        String code,
        String name,
        CityResponse city,
        RegionResponse region,
        AreaTypeResponse areaType,
        LocalDateTime createdDate
) { }
