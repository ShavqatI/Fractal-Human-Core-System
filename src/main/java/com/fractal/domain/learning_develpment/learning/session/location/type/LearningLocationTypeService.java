package com.fractal.domain.learning_develpment.learning.session.location.type;

import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeRequest;
import com.fractal.domain.learning_develpment.learning.session.location.type.dto.LearningLocationTypeResponse;

import java.util.List;

public interface LearningLocationTypeService {
   LearningLocationType create(LearningLocationTypeRequest dto);
   List<LearningLocationType> getAll();
   LearningLocationType getByCode(String code);
   LearningLocationType getById(Long id);
   LearningLocationType update(Long id, LearningLocationTypeRequest dto);
   void deleteById(Long id);
   LearningLocationTypeResponse toDTO(LearningLocationType learningLocationType);
}
