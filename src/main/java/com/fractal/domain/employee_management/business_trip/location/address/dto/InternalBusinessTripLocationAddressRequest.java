package com.fractal.domain.employee_management.business_trip.location.address.dto;

import jakarta.validation.constraints.NotNull;

public record InternalBusinessTripLocationAddressRequest(
        @NotNull
        Long organizationId

) implements BusinessTripLocationAddressRequest { }
