package com.fractal.domain.learning_develpment.learning.session.resource.dto;

import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeResponse;

import java.time.LocalDateTime;

public record LearningSessionResourceResponse(
        Long id,
        LearningSessionResourceTypeResponse candidateResourceType,
        String url,
        String fileName,
        String contentType,
        Long sizeInBytes,
        LocalDateTime createdDate
) {
}
