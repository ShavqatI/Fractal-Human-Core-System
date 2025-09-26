package com.fractal.domain.learning_develpment.learning.learner;

import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;

public interface LearnerService {
    Learner getById(Long id);
    LearnerCompactResponse toCompactDTO(Learner learner);
}
