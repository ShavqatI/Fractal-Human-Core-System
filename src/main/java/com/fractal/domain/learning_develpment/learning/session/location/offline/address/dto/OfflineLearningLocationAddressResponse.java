package com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto;

import com.fractal.domain.location.address.type.dto.AddressTypeResponse;
import com.fractal.domain.location.city.dto.CityCompactResponse;
import com.fractal.domain.location.country.dto.CountryCompactResponse;
import com.fractal.domain.location.district.dto.DistrictCompactResponse;
import com.fractal.domain.location.region.dto.RegionCompactResponse;

import java.time.LocalDateTime;

public record OfflineLearningLocationAddressResponse(
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
        String roomNumber,
        Double latitude,
        Double longitude,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {
}
