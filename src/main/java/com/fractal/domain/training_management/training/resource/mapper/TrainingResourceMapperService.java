package com.fractal.domain.training_management.training.resource.mapper;

import com.fractal.domain.training_management.training.resource.TrainingResource;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceRequest;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceResponse;

public interface TrainingResourceMapperService {
    TrainingResourceResponse toDTO(TrainingResource resource);
    TrainingResource toEntity(TrainingResourceRequest dto, String url);
    TrainingResource toEntity(TrainingResource resource, TrainingResourceRequest dto, String url);
}


