package com.fractal.domain.employee_management.business_trip.location;

import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationResponse;

import java.util.List;

public interface BusinessTripLocationService {
    BusinessTripLocation create(Long businessTripId, BusinessTripLocationRequest dto);

    List<BusinessTripLocation> getAllByBusinessTripId(Long businessTripId);

    BusinessTripLocation getById(Long businessTripId, Long id);

    BusinessTripLocation getById(Long id);

    BusinessTripLocationResponse toDTO(BusinessTripLocation location);

    BusinessTripLocation update(Long businessTripId, Long id, BusinessTripLocationRequest dto);

    void delete(Long businessTripId, Long id);

    BusinessTripLocation save(BusinessTripLocation location);


}
