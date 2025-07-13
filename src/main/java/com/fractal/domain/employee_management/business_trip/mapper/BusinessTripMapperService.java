package com.fractal.domain.employee_management.business_trip.mapper;

import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;

public interface BusinessTripMapperService {
    BusinessTripResponse toDTO(BusinessTrip businessTrip);
    BusinessTrip toEntity(BusinessTripRequest dto);
    BusinessTrip toEntity(BusinessTrip businessTrip, BusinessTripRequest dto);
}


