package com.fractal.domain.learning_develpment.learning.session.resource;

import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;

import java.util.List;

public interface LearningSessionResourceService {

    LearningSessionResource create(Long sessionId, LearningSessionResourceRequest dto);

    List<LearningSessionResource> getAllByLearningSessionId(Long sessionId);

    LearningSessionResource getById(Long sessionId, Long id);

    LearningSessionResource update(Long sessionId, Long id, LearningSessionResourceRequest dto);

    void delete(Long sessionId, Long id);

    LearningSessionResourceResponse toDTO(LearningSessionResource resource);
}
