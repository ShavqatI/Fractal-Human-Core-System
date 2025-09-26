package com.fractal.domain.learning_develpment.learning.learner.external.mapper;

import com.fractal.domain.learning_develpment.learning.learner.Learner;
import com.fractal.domain.learning_develpment.learning.learner.dto.LearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.ExternalLearner;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerResponse;

public interface ExternalLearnerMapperService {
    ExternalLearnerResponse toDTO(ExternalLearner learner);
    ExternalLearnerCompactResponse toCompactDTO(ExternalLearner learner);
    LearnerCompactResponse toCompactDTO(Learner learner);
    ExternalLearner toEntity(ExternalLearnerRequest dto);
    ExternalLearner toEntity(ExternalLearner learner, ExternalLearnerRequest dto);
}


