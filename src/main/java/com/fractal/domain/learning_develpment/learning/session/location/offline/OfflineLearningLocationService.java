package com.fractal.domain.learning_develpment.learning.session.location.offline;

import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationResponse;

import java.util.List;

public interface OfflineLearningLocationService {
    OfflineLearningLocation create(Long sessionId, OfflineLearningLocationRequest dto);

    List<OfflineLearningLocation> getAllByLearningSessionId(Long sessionId);

    OfflineLearningLocation getById(Long sessionId, Long id);

    OfflineLearningLocation getById(Long id);

    OfflineLearningLocationResponse toDTO(OfflineLearningLocation location);

    OfflineLearningLocation update(Long sessionId, Long id, OfflineLearningLocationRequest dto);

    void delete(Long sessionId, Long id);

    OfflineLearningLocation save(OfflineLearningLocation location);


}
