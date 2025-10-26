package com.fractal.domain.employee_management.relative.address.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RelativeAddressRequest(
        @NotNull
        Long addressTypeId,
        @NotNull
        Long countryId,
        Long regionId,
        Long cityId,
        Long districtId,
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
) { }
