package com.fractal.domain.training_management.training.resource.dto;

import com.fractal.domain.training_management.training.resource.type.dto.TrainingResourceTypeResponse;

import java.time.LocalDateTime;

public record TrainingResourceResponse(
        Long id,
        TrainingResourceTypeResponse candidateResourceType,
        String url,
        String fileName,
        String contentType,
        Long sizeInBytes,
        LocalDateTime createdDate
) {
}
