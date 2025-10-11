package com.fractal.domain.learning_develpment.learning.category;

import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryCompactResponse;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryRequest;
import com.fractal.domain.learning_develpment.learning.category.dto.LearningCategoryResponse;

import java.util.List;

public interface LearningCategoryService {

    LearningCategory create(LearningCategoryRequest dto);
    List<LearningCategory> getAll();
    LearningCategory getByCode(String code);
    LearningCategory getById(Long id);
    LearningCategory update(Long id, LearningCategoryRequest dto);
    void deleteById(Long id);
    LearningCategoryResponse toDTO(LearningCategory learningCategory);
    LearningCategoryCompactResponse toCompactDTO(LearningCategory learningCategory);

    LearningCategory addChild(Long learningCategoryId, LearningCategoryRequest dto);
    LearningCategory updateChild(Long learningCategoryId,Long id,LearningCategoryRequest dto);
    void deleteChild(Long learningCategoryId,Long id);
}
