package com.fractal.domain.learning_develpment.learning.learner.external;

import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerResponse;

import java.util.List;

public interface ExternalLearnerService {
    ExternalLearner create(ExternalLearnerRequest dto);
    List<ExternalLearner> getAll();
    ExternalLearner getById(Long id);
    ExternalLearner update(Long id, ExternalLearnerRequest dto);
    void deleteById(Long id);
    ExternalLearnerResponse toDTO(ExternalLearner learner);
    ExternalLearnerCompactResponse toCompactDTO(ExternalLearner learner);
    ExternalLearner save(ExternalLearner learner);


}
