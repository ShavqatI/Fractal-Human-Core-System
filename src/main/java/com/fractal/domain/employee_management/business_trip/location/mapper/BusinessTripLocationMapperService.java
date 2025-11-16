package com.fractal.domain.employee_management.business_trip.location.mapper;

import com.fractal.domain.employee_management.business_trip.location.BusinessTripLocation;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationRequest;
import com.fractal.domain.employee_management.business_trip.location.dto.BusinessTripLocationResponse;

public interface BusinessTripLocationMapperService {
    BusinessTripLocationResponse toDTO(BusinessTripLocation location);

    BusinessTripLocation toEntity(BusinessTripLocationRequest dto);

    BusinessTripLocation toEntity(BusinessTripLocation location, BusinessTripLocationRequest dto);
}


