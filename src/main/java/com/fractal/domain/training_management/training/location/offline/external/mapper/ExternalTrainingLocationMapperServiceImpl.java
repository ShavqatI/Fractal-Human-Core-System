package com.fractal.domain.training_management.training.location.offline.external.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.training_management.training.location.offline.external.ExternalTrainingLocation;
import com.fractal.domain.training_management.training.location.offline.external.address.mapper.ExternalTrainingLocationAddressMapperService;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationRequest;
import com.fractal.domain.training_management.training.location.offline.external.dto.ExternalTrainingLocationResponse;
import com.fractal.domain.training_management.training.location.type.TrainingLocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class ExternalTrainingLocationMapperServiceImpl implements ExternalTrainingLocationMapperService {

    private final TrainingLocationTypeService locationTypeService;
    private final StatusService statusService;
    private final ExternalTrainingLocationAddressMapperService addressMapperService;
    @Override
    public ExternalTrainingLocationResponse toDTO(ExternalTrainingLocation location) {
        return new ExternalTrainingLocationResponse(
                location.getId(),
                locationTypeService.toDTO(location.getTrainingLocationType()),
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
    public ExternalTrainingLocation toEntity(ExternalTrainingLocationRequest dto) {
        return mapToEntity(new ExternalTrainingLocation(), dto);
    }

    @Override
    public ExternalTrainingLocation toEntity(ExternalTrainingLocation location, ExternalTrainingLocationRequest dto) {
        return mapToEntity(location, dto);
    }

    private ExternalTrainingLocation mapToEntity(ExternalTrainingLocation location, ExternalTrainingLocationRequest dto) {
        location.setTrainingLocationType(locationTypeService.getByCode("EXTERNAL"));
        location.setCapacity(dto.capacity());
        location.setStatus(statusService.getById(dto.statusId()));
        dto.addresses().forEach(address->location.addAddress(addressMapperService.toEntity(address)));
        return location;
    }
}
