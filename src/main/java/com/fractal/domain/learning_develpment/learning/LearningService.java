package com.fractal.domain.learning_develpment.learning;

import com.fractal.domain.learning_develpment.learning.dto.LearningCompactResponse;
import com.fractal.domain.learning_develpment.learning.dto.LearningRequest;
import com.fractal.domain.learning_develpment.learning.dto.LearningResponse;

import java.util.List;

public interface LearningService {
    Learning create(LearningRequest dto);

    List<Learning> getAll();

    Learning getById(Long id);

    Learning update(Long id, LearningRequest dto);

    void deleteById(Long id);

    LearningResponse toDTO(Learning learning);

    LearningCompactResponse toCompactDTO(Learning learning);

    Learning save(Learning learning);


}
