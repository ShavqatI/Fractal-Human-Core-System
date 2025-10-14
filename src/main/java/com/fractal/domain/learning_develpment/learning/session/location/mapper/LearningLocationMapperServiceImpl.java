package com.fractal.domain.learning_develpment.learning.session.location.mapper;

import com.fractal.domain.learning_develpment.learning.session.location.LearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.dto.LearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.mapper.OfflineLearningLocationMapperService;
import com.fractal.domain.learning_develpment.learning.session.location.online.OnlineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.mapper.OnlineLearningLocationMapperService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LearningLocationMapperServiceImpl implements LearningLocationMapperService {

    private final OfflineLearningLocationMapperService offlineLearningLocationMapperService;
    private final OnlineLearningLocationMapperService onlineLearningLocationMapperService;

    @Override
    public LearningLocationResponse toDTO(LearningLocation location) {
        location = (LearningLocation) Hibernate.unproxy(location);
        if (location instanceof OfflineLearningLocation)
            return offlineLearningLocationMapperService.toDTO((OfflineLearningLocation) location);
        else return onlineLearningLocationMapperService.toDTO((OnlineLearningLocation) location);
    }

    @Override
    public LearningLocation toEntity(LearningLocationRequest dto) {
        if (dto instanceof OfflineLearningLocationRequest)
            return offlineLearningLocationMapperService.toEntity((OfflineLearningLocationRequest) dto);
        else return onlineLearningLocationMapperService.toEntity((OnlineLearningLocationRequest) dto);
    }
}
