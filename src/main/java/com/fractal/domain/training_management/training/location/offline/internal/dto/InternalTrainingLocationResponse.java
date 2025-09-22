package com.fractal.domain.training_management.training.location.offline.internal.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeResponse;

import java.time.LocalDateTime;

public record InternalTrainingLocationResponse(
        Long id,
        TrainingLocationTypeResponse locationTypeResponse,
        OrganizationCompactResponse organization,
        String buildingName,
        String floorNumber,
        String roomNumber,
        Integer capacity,
        StatusCompactResponse status,
        LocalDateTime createdDate

)
{ }
