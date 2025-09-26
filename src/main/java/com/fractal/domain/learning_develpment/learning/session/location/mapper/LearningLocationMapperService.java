package com.fractal.domain.learning_develpment.learning.session.location.mapper;

import com.fractal.domain.learning_develpment.learning.session.location.LearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationResponse;

public interface LearningLocationMapperService {
    LearningLocationResponse toDTO(LearningLocation location);
    LearningLocation toEntity(LearningLocationRequest dto);
    //OnlineLearningLocation toEntity(OnlineLearningLocationRequest dto);
    //LearningLocation toEntity(OnlineLearningLocation location, OnlineLearningLocationRequest dto);
}


