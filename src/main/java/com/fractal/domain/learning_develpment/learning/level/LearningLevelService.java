package com.fractal.domain.learning_develpment.learning.level;

import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelRequest;
import com.fractal.domain.learning_develpment.learning.level.dto.LearningLevelResponse;

import java.util.List;

public interface LearningLevelService {

    LearningLevel create(LearningLevelRequest dto);

    List<LearningLevel> getAll();

    LearningLevel getByCode(String code);

    LearningLevel getById(Long id);

    LearningLevel update(Long id, LearningLevelRequest dto);

    void deleteById(Long id);

    LearningLevelResponse toDTO(LearningLevel learningLevel);
}
