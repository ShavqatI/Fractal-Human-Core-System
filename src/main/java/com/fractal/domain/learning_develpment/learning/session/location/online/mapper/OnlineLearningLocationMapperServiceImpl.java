package com.fractal.domain.learning_develpment.learning.session.location.online.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.session.location.online.OnlineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.online.dto.OnlineLearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.type.TrainingLocationTypeService;
import com.fractal.domain.learning_develpment.learning.platform.OnlinePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OnlineLearningLocationMapperServiceImpl implements OnlineLearningLocationMapperService {

    private final TrainingLocationTypeService locationTypeService;
    private final OnlinePlatformService onlinePlatformService;
    private final StatusService statusService;

    @Override
    public OnlineLearningLocationResponse toDTO(OnlineLearningLocation location) {
        return new OnlineLearningLocationResponse(
                location.getId(),
                locationTypeService.toDTO(location.getLearningLocationType()),
                onlinePlatformService.toDTO(location.getOnlinePlatform()),
                location.getUlr(),
                location.getUsername(),
                location.getPassword(),
                location.getStartTime(),
                location.getEndTime(),
                location.getCapacity(),
                statusService.toCompactDTO(location.getStatus()),
                location.getCreatedDate()

        );
    }

    @Override
    public OnlineLearningLocation toEntity(OnlineLearningLocationRequest dto) {
        return mapToEntity(new OnlineLearningLocation(), dto);
    }

    @Override
    public OnlineLearningLocation toEntity(OnlineLearningLocation location, OnlineLearningLocationRequest dto) {
        return mapToEntity(location, dto);
    }

    private OnlineLearningLocation mapToEntity(OnlineLearningLocation location, OnlineLearningLocationRequest dto) {
        location.setLearningLocationType(locationTypeService.getByCode("ONLINE"));
        location.setOnlinePlatform(onlinePlatformService.getById(dto.onlinePlatformId()));
        location.setUlr(dto.url());
        location.setUsername(dto.username());
        location.setPassword(dto.password());
        location.setStartTime(dto.startTime());
        location.setEndTime(dto.endTime());
        location.setCapacity(dto.capacity());
        location.setStatus(statusService.getById(dto.statusId()));
        return location;
    }
}
