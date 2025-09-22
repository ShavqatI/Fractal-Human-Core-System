package com.fractal.domain.training_management.training.resource.type;

import com.fractal.domain.training_management.training.resource.type.dto.TrainingResourceTypeRequest;
import com.fractal.domain.training_management.training.resource.type.dto.TrainingResourceTypeResponse;

import java.util.List;

public interface TrainingResourceTypeService {
   TrainingResourceType create(TrainingResourceTypeRequest dto);
   List<TrainingResourceType> getAll();
   TrainingResourceType getByCode(String code);
   TrainingResourceType getById(Long id);
   TrainingResourceType update(Long id, TrainingResourceTypeRequest dto);
   void deleteById(Long id);
   TrainingResourceTypeResponse toDTO(TrainingResourceType trainingResourceType);
}
