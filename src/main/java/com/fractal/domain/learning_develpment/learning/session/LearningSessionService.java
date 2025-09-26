package com.fractal.domain.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionRequest;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionResponse;

import java.util.List;
public interface LearningSessionService {

    LearningSession create(Long learningId, LearningSessionRequest dto);
    List<LearningSession> getAllByLearningId(Long learningId);
    LearningSession getById(Long learningId , Long id);
    LearningSession getById(Long id);
    LearningSessionResponse toDTO(LearningSession session);
    LearningSessionCompactResponse toCompactDTO(LearningSession session);
    LearningSession update(Long testId, Long id, LearningSessionRequest dto);
    void delete(Long learningId,Long id);
    LearningSession save(LearningSession session);

}
