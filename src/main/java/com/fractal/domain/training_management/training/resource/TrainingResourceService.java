package com.fractal.domain.training_management.training.resource;

import com.fractal.domain.training_management.training.resource.dto.TrainingResourceRequest;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceResponse;

import java.util.List;

public interface TrainingResourceService {

    TrainingResource create(Long candidateId, TrainingResourceRequest dto);
    List<TrainingResource> getAllByEducationId(Long candidateId);
    TrainingResource getById(Long candidateId , Long id);
    TrainingResource update(Long candidateId, Long id, TrainingResourceRequest dto);
    void delete(Long candidateId,Long id);
    TrainingResourceResponse toDTO(TrainingResource resource);
}
