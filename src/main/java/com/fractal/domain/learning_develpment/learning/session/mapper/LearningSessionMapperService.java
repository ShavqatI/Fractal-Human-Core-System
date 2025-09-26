package com.fractal.domain.learning_develpment.learning.session.mapper;

import com.fractal.domain.learning_develpment.learning.session.LearningSession;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionRequest;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionResponse;

public interface LearningSessionMapperService {
    LearningSessionResponse toDTO(LearningSession learningSession);
    LearningSessionCompactResponse toCompactDTO(LearningSession learningSession);
    LearningSession toEntity(LearningSessionRequest dto);
    LearningSession toEntity(LearningSession learningSession, LearningSessionRequest dto);
}


