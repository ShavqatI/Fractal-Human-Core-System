package com.fractal.domain.training_management.training.location.offline.internal.mapper;

import com.fractal.domain.training_management.training.location.offline.internal.InternalTrainingLocation;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationResponse;

public interface InternalTrainingLocationMapperService {
    InternalTrainingLocationResponse toDTO(InternalTrainingLocation location);
    InternalTrainingLocation toEntity(InternalTrainingLocationRequest dto);
    InternalTrainingLocation toEntity(InternalTrainingLocation location, InternalTrainingLocationRequest dto);
}


