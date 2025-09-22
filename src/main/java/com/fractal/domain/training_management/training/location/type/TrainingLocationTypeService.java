package com.fractal.domain.training_management.training.location.type;

import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeRequest;
import com.fractal.domain.training_management.training.location.type.dto.TrainingLocationTypeResponse;

import java.util.List;

public interface TrainingLocationTypeService {
   TrainingLocationType create(TrainingLocationTypeRequest dto);
   List<TrainingLocationType> getAll();
   TrainingLocationType getByCode(String code);
   TrainingLocationType getById(Long id);
   TrainingLocationType update(Long id, TrainingLocationTypeRequest dto);
   void deleteById(Long id);
   TrainingLocationTypeResponse toDTO(TrainingLocationType trainingLocationType);
}
