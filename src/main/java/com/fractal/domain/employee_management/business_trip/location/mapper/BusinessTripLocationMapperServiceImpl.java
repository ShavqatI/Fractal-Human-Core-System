package com.fractal.domain.employee_management.business_trip.location.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.location.BusinessTripLocation;
import com.fractal.domain.employee_management.business_trip.location.address.mapper.BusinessTripLocationAddressMapperService;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationResponse;
import com.fractal.domain.employee_management.business_trip.location.type.BusinessTripLocationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class BusinessTripLocationMapperServiceImpl implements BusinessTripLocationMapperService {

    private final BusinessTripLocationTypeService locationTypeService;
    private final StatusService statusService;
    private final BusinessTripLocationAddressMapperService addressMapperService;

    @Override
    public BusinessTripLocationResponse toDTO(BusinessTripLocation location) {
        return new BusinessTripLocationResponse(
                location.getId(),
                locationTypeService.toDTO(location.getBusinessTripLocationType()),
                location.getStartTime(),
                location.getEndTime(),
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
    public BusinessTripLocation toEntity(BusinessTripLocationRequest dto) {
        var location =  mapToEntity(new BusinessTripLocation(), dto);
        location.setStatus(statusService.getByCode("CREATED"));
        return location;
    }

    @Override
    public BusinessTripLocation toEntity(BusinessTripLocation location, BusinessTripLocationRequest dto) {
        return mapToEntity(location, dto);
    }

    private BusinessTripLocation mapToEntity(BusinessTripLocation location, BusinessTripLocationRequest dto) {
        location.setBusinessTripLocationType(locationTypeService.getById(dto.locationTypeId()));
        location.setStartTime(dto.startTime());
        location.setEndTime(dto.endTime());
        dto.addresses().forEach(address -> location.addAddress(addressMapperService.toEntity(address)));
        return location;
    }
}
