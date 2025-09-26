package com.fractal.domain.learning_develpment.learning.session.resource.mapper;

import com.fractal.domain.learning_develpment.learning.session.resource.LearningSessionResource;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;

public interface LearningSessionResourceMapperService {
    LearningSessionResourceResponse toDTO(LearningSessionResource resource);
    LearningSessionResource toEntity(LearningSessionResourceRequest dto, String url);
    LearningSessionResource toEntity(LearningSessionResource resource, LearningSessionResourceRequest dto, String url);
}


