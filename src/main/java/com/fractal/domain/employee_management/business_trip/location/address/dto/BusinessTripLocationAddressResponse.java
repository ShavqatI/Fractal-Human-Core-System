package com.fractal.domain.employee_management.business_trip.location.address.dto;

import com.fractal.domain.location.address.type.dto.AddressTypeResponse;
import com.fractal.domain.location.city.dto.CityCompactResponse;
import com.fractal.domain.location.country.dto.CountryCompactResponse;
import com.fractal.domain.location.district.dto.DistrictCompactResponse;
import com.fractal.domain.location.region.dto.RegionCompactResponse;

import java.time.LocalDateTime;

public record BusinessTripLocationAddressResponse(
        Long id,
        AddressTypeResponse addressType,
        CountryCompactResponse country,
        RegionCompactResponse region,
        CityCompactResponse city,
        DistrictCompactResponse district,
        String street,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) { }
