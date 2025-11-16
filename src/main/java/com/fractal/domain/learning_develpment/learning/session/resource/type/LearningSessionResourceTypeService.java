package com.fractal.domain.learning_develpment.learning.session.resource.type;

import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.type.dto.LearningSessionResourceTypeResponse;

import java.util.List;

public interface LearningSessionResourceTypeService {
    LearningSessionResourceType create(LearningSessionResourceTypeRequest dto);

    List<LearningSessionResourceType> getAll();

    LearningSessionResourceType getByCode(String code);

    LearningSessionResourceType getById(Long id);

    LearningSessionResourceType update(Long id, LearningSessionResourceTypeRequest dto);

    void deleteById(Long id);

    LearningSessionResourceTypeResponse toDTO(LearningSessionResourceType learningSessionResourceType);
}
