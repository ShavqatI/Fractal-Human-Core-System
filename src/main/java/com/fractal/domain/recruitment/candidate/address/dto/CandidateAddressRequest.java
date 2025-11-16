package com.fractal.domain.recruitment.candidate.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CandidateAddressRequest(

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
        String apartment

) {
}
