package com.fractal.domain.training_management.training.location.online.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.organization_management.organization.dto.OrganizationCompactResponse;
import com.fractal.domain.training_management.training.location.online.platform.dto.OnlinePlatformResponse;
import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeResponse;

import java.time.LocalDateTime;

public record OnlineTrainingLocationResponse(
        Long id,
        TrainingLocationTypeResponse locationTypeResponse,
        OnlinePlatformResponse onlinePlatform,
        String buildingName,
        String floorNumber,
        String roomNumber,
        Integer capacity,
        StatusCompactResponse status,
        LocalDateTime createdDate

)
{ }
