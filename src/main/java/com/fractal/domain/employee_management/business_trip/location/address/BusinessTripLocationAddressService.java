package com.fractal.domain.employee_management.business_trip.location.address;

import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressResponse;

import java.util.List;

public interface BusinessTripLocationAddressService {

    BusinessTripLocationAddress create(Long locationId, BusinessTripLocationAddressRequest dto);

    BusinessTripLocationAddress getById(Long locationId, Long id);

    List<BusinessTripLocationAddress> getAllByBusinessTripLocationId(Long locationId);

    BusinessTripLocationAddress update(Long locationId, Long id, BusinessTripLocationAddressRequest dto);

    void delete(Long externalTrainingLocationId, Long id);

    BusinessTripLocationAddressResponse toDTO(BusinessTripLocationAddress address);
}
