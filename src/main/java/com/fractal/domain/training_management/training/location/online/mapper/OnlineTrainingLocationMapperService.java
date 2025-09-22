package com.fractal.domain.training_management.training.location.online.mapper;

import com.fractal.domain.training_management.training.location.online.OnlineTrainingLocation;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationResponse;

public interface OnlineTrainingLocationMapperService {
    OnlineTrainingLocationResponse toDTO(OnlineTrainingLocation location);
    OnlineTrainingLocation toEntity(OnlineTrainingLocationRequest dto);
    OnlineTrainingLocation toEntity(OnlineTrainingLocation location, OnlineTrainingLocationRequest dto);
}


