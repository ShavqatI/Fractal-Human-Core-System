package com.fractal.domain.training_management.training.type;

import com.fractal.domain.training_management.training.type.dto.TrainingTypeRequest;
import com.fractal.domain.training_management.training.type.dto.TrainingTypeResponse;

import java.util.List;

public interface TrainingTypeService {
   TrainingType create(TrainingTypeRequest dto);
   List<TrainingType> getAll();
   TrainingType getByCode(String code);
   TrainingType getById(Long id);
   TrainingType update(Long id, TrainingTypeRequest dto);
   void deleteById(Long id);
   TrainingTypeResponse toDTO(TrainingType trainingType);
}
