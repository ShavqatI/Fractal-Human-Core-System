package com.fractal.domain.organization_management.organization.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OrganizationAddressRequest(
        @NotBlank
        @NotNull
        String addressType,
        @NotNull
        Long country,
        @NotNull
        Long region,
        @NotNull
        Long city,
        @NotNull
        Long district,
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
) { }
