package com.fractal.domain.integration.mapping.order_type.dto;

public record OrderTypeMappingRequest(
         Long orderTypeId,
         String referenceType,
         String reference,
         Long statusId
) { }
