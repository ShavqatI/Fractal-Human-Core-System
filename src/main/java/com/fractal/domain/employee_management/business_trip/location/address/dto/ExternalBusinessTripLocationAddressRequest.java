package com.fractal.domain.employee_management.business_trip.location.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExternalBusinessTripLocationAddressRequest(

        @NotNull
        Long addressTypeId,
        @NotNull
        Long countryId,
        Long regionId,
        Long cityId,
        Long districtId,
        @NotBlank
        String street
) implements BusinessTripLocationAddressRequest { }
