package com.fractal.domain.employee_management.business_trip.location.address;

import com.fractal.domain.employee_management.business_trip.location.BusinessTripLocationService;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressResponse;
import com.fractal.domain.employee_management.business_trip.location.address.mapper.BusinessTripLocationAddressMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripLocationAddressServiceImpl implements BusinessTripLocationAddressService {

    private final BusinessTripLocationAddressRepository businessTripLocationAddressRepository;
    private final BusinessTripLocationAddressMapperService addressMapperService;
    private final BusinessTripLocationService locationService;


    @Override
    @Transactional
    public BusinessTripLocationAddress create(Long locationId, BusinessTripLocationAddressRequest dto) {
        var location = locationService.getById(locationId);
        var address = addressMapperService.toEntity(dto);
        location.addAddress(address);
        locationService.save(location);
        return address;
    }


    @Override
    public List<BusinessTripLocationAddress> getAllByBusinessTripLocationId(Long locationId) {
        return businessTripLocationAddressRepository.findAllByBusinessTripLocationId(locationId);
    }

    @Override
    public BusinessTripLocationAddress getById(Long locationId, Long id) {
        return businessTripLocationAddressRepository.findByBusinessTripLocationIdAndId(locationId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public BusinessTripLocationAddress update(Long locationId, Long id, BusinessTripLocationAddressRequest dto) {
        var location = locationService.getById(locationId);
        var address = location.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        address = businessTripLocationAddressRepository.save(addressMapperService.toEntity(address, dto));
        locationService.save(location);
        return address;
    }

    @Override
    public void delete(Long externalTrainingLocationId, Long id) {
        var location = locationService.getById(externalTrainingLocationId);
        var address = location.getAddresses()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        location.removeAddress(address);
        locationService.save(location);
    }

    @Override
    public BusinessTripLocationAddressResponse toDTO(BusinessTripLocationAddress address) {
        return addressMapperService.toDTO(address);
    }
}
