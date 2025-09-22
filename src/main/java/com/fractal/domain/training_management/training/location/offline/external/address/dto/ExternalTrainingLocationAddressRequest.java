package com.fractal.domain.training_management.training.location.offline.external.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExternalTrainingLocationAddressRequest(

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
        Double longitude
) { }
