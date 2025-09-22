package com.fractal.domain.training_management.training.resource.dto;

import org.springframework.web.multipart.MultipartFile;

public record TrainingResourceRequest(
        Long candidateResourceTypeId,
        MultipartFile file

) { }
