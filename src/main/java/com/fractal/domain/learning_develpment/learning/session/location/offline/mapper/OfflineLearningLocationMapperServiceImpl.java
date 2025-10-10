package com.fractal.domain.learning_develpment.learning.session.location.offline.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.learning_develpment.learning.session.location.offline.OfflineLearningLocation;
import com.fractal.domain.learning_develpment.learning.session.location.offline.address.mapper.OfflineLearningLocationAddressMapperService;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationRequest;
import com.fractal.domain.learning_develpment.learning.session.location.offline.dto.OfflineLearningLocationResponse;
import com.fractal.domain.learning_develpment.learning.session.location.type.LearningLocationTypeService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class OfflineLearningLocationMapperServiceImpl implements OfflineLearningLocationMapperService {

    private final LearningLocationTypeService locationTypeService;
    private final StatusService statusService;
    private final OfflineLearningLocationAddressMapperService addressMapperService;


    @Override
    public OfflineLearningLocationResponse toDTO(OfflineLearningLocation location) {
        return new OfflineLearningLocationResponse(
                location.getId(),
                locationTypeService.toDTO(location.getLearningLocationType()),
                location.getStartTime(),
                location.getEndTime(),
                location.getCapacity(),
                Optional.ofNullable(location.getAddresses())
                        .orElse(emptyList())
                        .stream()
                        .map(addressMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(location.getStatus()),
                location.getCreatedDate()

        );
    }

    @Override
    public OfflineLearningLocation toEntity(OfflineLearningLocationRequest dto) {
        return mapToEntity(new OfflineLearningLocation(), dto);
    }

    @Override
    public OfflineLearningLocation toEntity(OfflineLearningLocation location, OfflineLearningLocationRequest dto) {
        return mapToEntity(location, dto);
    }

    private OfflineLearningLocation mapToEntity(OfflineLearningLocation location, OfflineLearningLocationRequest dto) {
        location.setLearningLocationType(locationTypeService.getByCode("EXTERNAL"));
        location.setStartTime(dto.startTime());
        location.setEndTime(dto.endTime());
        location.setCapacity(dto.capacity());
        location.setStatus(statusService.getById(dto.statusId()));
        dto.addresses().forEach(address->location.addAddress(addressMapperService.toEntity(address)));
        return location;
    }
}
