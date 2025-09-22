package com.fractal.domain.training_management.training.location.offline.internal.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.training_management.training.location.offline.internal.InternalTrainingLocation;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.internal.dto.InternalTrainingLocationResponse;
import com.fractal.domain.training_management.training.location.type.TrainingLocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InternalTrainingLocationMapperServiceImpl implements InternalTrainingLocationMapperService {

    private final TrainingLocationTypeService locationTypeService;
    private final OrganizationService organizationService;
    private final StatusService statusService;

    @Override
    public InternalTrainingLocationResponse toDTO(InternalTrainingLocation location) {
        return new InternalTrainingLocationResponse(
                location.getId(),
                locationTypeService.toDTO(location.getTrainingLocationType()),
                organizationService.toCompactDTO(location.getOrganization()),
                location.getBuildingName(),
                location.getFloorNumber(),
                location.getRoomNumber(),
                location.getCapacity(),
                statusService.toCompactDTO(location.getStatus()),
                location.getCreatedDate()

        );
    }

    @Override
    public InternalTrainingLocation toEntity(InternalTrainingLocationRequest dto) {
        return mapToEntity(new InternalTrainingLocation(), dto);
    }

    @Override
    public InternalTrainingLocation toEntity(InternalTrainingLocation location, InternalTrainingLocationRequest dto) {
        return mapToEntity(location, dto);
    }

    private InternalTrainingLocation mapToEntity(InternalTrainingLocation location, InternalTrainingLocationRequest dto) {
        location.setTrainingLocationType(locationTypeService.getByCode("INTERNAL"));
        location.setOrganization(organizationService.getById(dto.organizationId()));
        location.setBuildingName(dto.buildingName());
        location.setFloorNumber(dto.floorNumber());
        location.setRoomNumber(dto.roomNumber());
        location.setCapacity(dto.capacity());
        location.setStatus(statusService.getById(dto.statusId()));
        return location;
    }
}
