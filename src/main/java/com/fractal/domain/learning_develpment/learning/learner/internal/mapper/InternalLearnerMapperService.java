package com.fractal.domain.learning_develpment.learning.learner.internal.mapper;

import com.fractal.domain.learning_develpment.learning.learner.internal.InternalLearner;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerResponse;

public interface InternalLearnerMapperService {
    InternalLearnerResponse toDTO(InternalLearner learner);
    InternalLearnerCompactResponse toCompactDTO(InternalLearner learner);
    InternalLearner toEntity(InternalLearnerRequest dto);
    InternalLearner toEntity(InternalLearner trainer, InternalLearnerRequest dto);
}


