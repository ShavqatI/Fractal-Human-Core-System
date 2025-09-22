package com.fractal.domain.training_management.training.location.offline.external;

import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationResponse;

import java.util.List;

public interface ExternalTrainingLocationService {
    ExternalTrainingLocation create(Long trainingId, ExternalTrainingLocationRequest dto);
    List<ExternalTrainingLocation> getAllByTrainingId(Long trainingId);
    ExternalTrainingLocation getById(Long trainingId , Long id);
    ExternalTrainingLocation getById(Long id);
    ExternalTrainingLocationResponse toDTO(ExternalTrainingLocation location);
    ExternalTrainingLocation update(Long trainingId, Long id, ExternalTrainingLocationRequest dto);
    void delete(Long trainingId,Long id);
    ExternalTrainingLocation save(ExternalTrainingLocation trainingLocation);

}
