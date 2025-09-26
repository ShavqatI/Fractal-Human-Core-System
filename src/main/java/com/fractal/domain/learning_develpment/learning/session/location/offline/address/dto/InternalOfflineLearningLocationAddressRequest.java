package com.fractal.domain.learning_develpment.learning.session.location.offline.address.dto;

import jakarta.validation.constraints.NotNull;

public record InternalOfflineLearningLocationAddressRequest(
        @NotNull
        Long organizationId,
        String roomNumber

) implements OfflineLearningLocationAddressRequest { }
