package com.fractal.domain.training_management.training.location.offline.external.mapper;

import com.fractal.domain.training_management.training.location.offline.external.ExternalTrainingLocation;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationResponse;

public interface ExternalTrainingLocationMapperService {
    ExternalTrainingLocationResponse toDTO(ExternalTrainingLocation location);
    ExternalTrainingLocation toEntity(ExternalTrainingLocationRequest dto);
    ExternalTrainingLocation toEntity(ExternalTrainingLocation location, ExternalTrainingLocationRequest dto);
}


