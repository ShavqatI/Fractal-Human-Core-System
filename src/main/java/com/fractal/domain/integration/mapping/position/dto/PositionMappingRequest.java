package com.fractal.domain.integration.mapping.position.dto;

public record PositionMappingRequest(
         Long positionId,
         String referenceType,
         String reference,
         Long statusId
) { }
