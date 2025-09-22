package com.fractal.domain.training_management.training.location.offline.internal;

import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationResponse;

import java.util.List;

public interface InternalTrainingLocationService {
    InternalTrainingLocation create(Long trainingId, InternalTrainingLocationRequest dto);
    List<InternalTrainingLocation> getAllByTrainingId(Long trainingId);
    InternalTrainingLocation getById(Long trainingId , Long id);
    InternalTrainingLocationResponse toDTO(InternalTrainingLocation location);
    InternalTrainingLocation update(Long trainingId, Long id, InternalTrainingLocationRequest dto);
    void delete(Long trainingId,Long id);


}
