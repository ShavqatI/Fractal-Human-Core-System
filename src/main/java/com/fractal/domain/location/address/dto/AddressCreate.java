package com.fractal.domain.location.address.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AddressCreate(
        @NotBlank
        @NotBlank
        String addressType,
        @NotBlank
        @NotBlank
        Long country,
        @NotBlank
        @NotBlank
        Long region,
        @NotBlank
        @NotBlank
        Long city,
        @NotBlank
        @NotBlank
        long district,
        @NotBlank
        @NotBlank
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
