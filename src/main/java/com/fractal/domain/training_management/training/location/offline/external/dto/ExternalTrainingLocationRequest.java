package com.fractal.domain.training_management.training.location.offline.external.dto;

import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressRequest;

import java.util.List;

public record ExternalTrainingLocationRequest(
        Integer capacity,
        List<ExternalTrainingLocationAddressRequest> addresses,
        Long statusId
) { }
