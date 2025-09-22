package com.fractal.domain.training_management.training.location.online.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.training_management.training.location.online.OnlineTrainingLocation;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.online.dto.OnlineTrainingLocationResponse;
import com.fractal.domain.training_management.training.location.online.platform.OnlinePlatformService;
import com.fractal.domain.training_management.training.location.type.TrainingLocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OnlineTrainingLocationMapperServiceImpl implements OnlineTrainingLocationMapperService {

    private final TrainingLocationTypeService locationTypeService;
    private final OnlinePlatformService onlinePlatformService;
    private final StatusService statusService;

    @Override
    public OnlineTrainingLocationResponse toDTO(OnlineTrainingLocation location) {
        return new OnlineTrainingLocationResponse(
                location.getId(),
                locationTypeService.toDTO(location.getTrainingLocationType()),
                onlinePlatformService.toDTO(location.getOnlinePlatform()),
                location.getLink(),
                location.getUsername(),
                location.getPassword(),
                location.getCapacity(),
                statusService.toCompactDTO(location.getStatus()),
                location.getCreatedDate()

        );
    }

    @Override
    public OnlineTrainingLocation toEntity(OnlineTrainingLocationRequest dto) {
        return mapToEntity(new OnlineTrainingLocation(), dto);
    }

    @Override
    public OnlineTrainingLocation toEntity(OnlineTrainingLocation location, OnlineTrainingLocationRequest dto) {
        return mapToEntity(location, dto);
    }

    private OnlineTrainingLocation mapToEntity(OnlineTrainingLocation location, OnlineTrainingLocationRequest dto) {
        location.setTrainingLocationType(locationTypeService.getByCode("ONLINE"));
        location.setOnlinePlatform(onlinePlatformService.getById(dto.onlinePlatformId()));
        location.setLink(dto.link());
        location.setUsername(dto.username());
        location.setPassword(dto.password());
        location.setCapacity(dto.capacity());
        location.setStatus(statusService.getById(dto.statusId()));
        return location;
    }
}
