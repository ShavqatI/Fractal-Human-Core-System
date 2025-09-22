package com.fractal.domain.training_management.training.location.offline.internal.dto;

public record InternalTrainingLocationRequest(
        Long organizationId,
        String buildingName,
        String floorNumber,
        String roomNumber,
        Integer capacity,
        Long statusId
) { }
