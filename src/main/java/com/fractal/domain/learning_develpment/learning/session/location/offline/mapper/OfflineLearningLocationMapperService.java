package com.fractal.domain.learning_develpment.learning.session.location.offline.mapper;

import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationResponse;

public interface OfflineLearningLocationMapperService {
    OfflineLearningLocationResponse toDTO(OfflineLearningLocation location);
    OfflineLearningLocation toEntity(OfflineLearningLocationRequest dto);
    OfflineLearningLocation toEntity(OfflineLearningLocation location, OfflineLearningLocationRequest dto);
}


