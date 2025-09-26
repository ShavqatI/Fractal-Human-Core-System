package com.fractal.domain.learning_develpment.learning.type;

import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeRequest;
import com.fractal.domain.learning_develpment.learning.type.dto.LearningTypeResponse;

import java.util.List;

public interface LearningTypeService {

    LearningType create(LearningTypeRequest dto);
    List<LearningType> getAll();
    LearningType getByCode(String code);
    LearningType getById(Long id);
    LearningType update(Long id, LearningTypeRequest dto);
    void deleteById(Long id);
    LearningTypeResponse toDTO(LearningType learningType);
}
