package com.fractal.domain.employee_management.business_trip.location;

import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationResponse;
import com.fractal.domain.employee_management.business_trip.location.mapper.BusinessTripLocationMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BusinessTripLocationServiceImpl implements BusinessTripLocationService {

    private final BusinessTripLocationRepository locationRepository;
    private final BusinessTripLocationMapperService mapperService;
    private final BusinessTripService businessTripService;

    @Override
    public BusinessTripLocation create(Long businessTripId, BusinessTripLocationRequest dto) {
        var businessTrip = businessTripService.getById(businessTripId);
        var location = mapperService.toEntity(dto);
        businessTrip.addLocation(location);
        businessTripService.save(businessTrip);
        return location;
    }

    @Override
    public List<BusinessTripLocation> getAllByBusinessTripId(Long businessTripId) {
        return locationRepository.findAllByBusinessTripId(businessTripId);
    }

    @Override
    public BusinessTripLocation getById(Long businessTripId, Long id) {
        return locationRepository.findByBusinessTripIdAndId(businessTripId,id).orElseThrow(()->new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public BusinessTripLocation getById(Long id) {
        return locationRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public BusinessTripLocationResponse toDTO(BusinessTripLocation location) {
        return mapperService.toDTO(location);
    }

    @Override
    public BusinessTripLocation update(Long businessTripId, Long id, BusinessTripLocationRequest dto) {
        var businessTrip = businessTripService.getById(businessTripId);
        var location = businessTrip.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        location = mapperService.toEntity(location,dto);
        locationRepository.save(location);
        businessTripService.save(businessTrip);
        return location;
    }

    @Override
    public void delete(Long businessTripId, Long id) {
        var businessTrip = businessTripService.getById(businessTripId);
        var location = businessTrip.getLocations()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        businessTrip.removeLocation(location);
        businessTripService.save(businessTrip);
    }

    @Override
    public BusinessTripLocation save(BusinessTripLocation location) {
        try {
            return locationRepository.save(location);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
