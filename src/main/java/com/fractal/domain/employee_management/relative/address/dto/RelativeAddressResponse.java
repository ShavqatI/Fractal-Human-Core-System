package com.fractal.domain.employee_management.relative.address.dto;

import com.fractal.domain.location.address.type.dto.AddressTypeResponse;
import com.fractal.domain.location.city.dto.CityCompactResponse;
import com.fractal.domain.location.country.dto.CountryCompactResponse;
import com.fractal.domain.location.district.dto.DistrictCompactResponse;
import com.fractal.domain.location.region.dto.RegionCompactResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RelativeAddressResponse(
        Long id,
        AddressTypeResponse addressType,
        CountryCompactResponse country,
        RegionCompactResponse region,
        CityCompactResponse city,
        DistrictCompactResponse district,
        String street,
        String house,
        String apartment,
        String postalCode,
        String buildingNumber,
        String floorNumber,
        Double latitude,
        Double longitude,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime createdDate,
        LocalDateTime updatedDate

) {
}
