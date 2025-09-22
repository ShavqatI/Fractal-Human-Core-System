package com.fractal.domain.training_management.training.location.offline.external.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.training_management.training.location.offline.external.address.dto.ExternalTrainingLocationAddressResponse;
import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeResponse;

import java.time.LocalDateTime;
import java.util.List;

public record ExternalTrainingLocationResponse(
        Long id,
        TrainingLocationTypeResponse locationTypeResponse,
        Integer capacity,
        List<ExternalTrainingLocationAddressResponse> addresses,
        StatusCompactResponse status,
        LocalDateTime createdDate

)
{ }
