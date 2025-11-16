package com.fractal.domain.learning_develpment.learning.mapper;

import com.fractal.domain.learning_develpment.learning.Learning;
import com.fractal.domain.learning_develpment.learning.dto.LearningCompactResponse;
import com.fractal.domain.learning_develpment.learning.dto.LearningRequest;
import com.fractal.domain.learning_develpment.learning.dto.LearningResponse;

public interface LearningMapperService {
    LearningResponse toDTO(Learning learning);

    LearningCompactResponse toCompactDTO(Learning learning);

    Learning toEntity(LearningRequest dto);

    Learning toEntity(Learning learning, LearningRequest dto);
}


