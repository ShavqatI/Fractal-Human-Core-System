package com.fractal.domain.learning_develpment.learning.learner.internal;

import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerResponse;

import java.util.List;

public interface InternalLearnerService {
    InternalLearner create(InternalLearnerRequest dto);

    List<InternalLearner> getAll();

    InternalLearner getById(Long id);

    InternalLearner update(Long id, InternalLearnerRequest dto);

    void deleteById(Long id);

    InternalLearnerResponse toDTO(InternalLearner learner);

    InternalLearnerCompactResponse toCompactDTO(InternalLearner learner);


}
