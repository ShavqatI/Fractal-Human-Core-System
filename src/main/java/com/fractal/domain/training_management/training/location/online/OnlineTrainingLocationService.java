package com.fractal.domain.training_management.training.location.online;

import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationResponse;

import java.util.List;

public interface OnlineTrainingLocationService {
    OnlineTrainingLocation create(Long trainingId, OnlineTrainingLocationRequest dto);
    List<OnlineTrainingLocation> getAllByTrainingId(Long trainingId);
    OnlineTrainingLocation getById(Long trainingId , Long id);
    OnlineTrainingLocationResponse toDTO(OnlineTrainingLocation location);
    OnlineTrainingLocation update(Long trainingId, Long id, OnlineTrainingLocationRequest dto);
    void delete(Long trainingId,Long id);


}
