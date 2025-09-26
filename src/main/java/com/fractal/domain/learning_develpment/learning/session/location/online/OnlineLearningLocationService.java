package com.fractal.domain.learning_develpment.learning.session.location.online;

import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationResponse;

import java.util.List;

public interface OnlineLearningLocationService {
    OnlineLearningLocation create(Long sessionId, OnlineLearningLocationRequest dto);
    List<OnlineLearningLocation> getAllByLearningSessionId(Long sessionId);
    OnlineLearningLocation getById(Long sessionId , Long id);
    OnlineLearningLocationResponse toDTO(OnlineLearningLocation location);
    OnlineLearningLocation update(Long sessionId, Long id, OnlineLearningLocationRequest dto);
    void delete(Long sessionId,Long id);


}
