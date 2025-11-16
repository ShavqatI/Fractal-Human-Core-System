package com.fractal.domain.learning_develpment.learning.session.resource.dto;

import org.springframework.web.multipart.MultipartFile;

public record LearningSessionResourceRequest(
        Long resourceTypeId,
        MultipartFile file

) {
}
