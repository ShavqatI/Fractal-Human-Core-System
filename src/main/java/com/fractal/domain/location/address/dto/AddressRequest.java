package com.fractal.domain.location.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AddressRequest(
        @NotBlank
        @NotNull
        Long addressTypeId,
        @NotNull
        Long countryId,
        @NotNull
        Long regionId,
        @NotNull
        Long cityId,
        @NotNull
        Long districtId,
        @NotBlank
        @NotNull
        String street,
        String house,
        String apartment,
        String postalCode,
        String buildingNumber,
        String floorNumber,
        Double latitude,
        Double longitude,
        LocalDate startDate,
        LocalDate endDate
) {
}
