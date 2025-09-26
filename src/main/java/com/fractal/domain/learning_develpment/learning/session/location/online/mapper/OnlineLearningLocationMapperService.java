package com.fractal.domain.learning_develpment.learning.session.location.online.mapper;

import com.fractal.domain.learning_develpment.learning.session.location.online.OnlineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationResponse;

public interface OnlineLearningLocationMapperService {
    OnlineLearningLocationResponse toDTO(OnlineLearningLocation location);
    OnlineLearningLocation toEntity(OnlineLearningLocationRequest dto);
    OnlineLearningLocation toEntity(OnlineLearningLocation location, OnlineLearningLocationRequest dto);
}


