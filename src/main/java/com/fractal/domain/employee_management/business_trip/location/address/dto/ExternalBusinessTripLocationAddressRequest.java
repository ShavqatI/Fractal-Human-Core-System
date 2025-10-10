package com.fractal.domain.employee_management.business_trip.location.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExternalBusinessTripLocationAddressRequest(

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
        String street
) implements BusinessTripLocationAddressRequest { }
