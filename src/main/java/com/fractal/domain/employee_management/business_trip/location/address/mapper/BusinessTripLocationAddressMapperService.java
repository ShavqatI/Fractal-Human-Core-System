package com.fractal.domain.employee_management.business_trip.location.address.mapper;

import com.fractal.domain.employee_management.business_trip.location.address.BusinessTripLocationAddress;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.BusinessTripLocationAddressResponse;
import com.fractal.domain.employee_management.business_trip.location.address.dto.ExternalBusinessTripLocationAddressRequest;
import com.fractal.domain.employee_management.business_trip.location.address.dto.InternalBusinessTripLocationAddressRequest;

public interface BusinessTripLocationAddressMapperService {
    BusinessTripLocationAddressResponse toDTO(BusinessTripLocationAddress address);

    BusinessTripLocationAddress toEntity(ExternalBusinessTripLocationAddressRequest dto);

    BusinessTripLocationAddress toEntity(InternalBusinessTripLocationAddressRequest dto);

    BusinessTripLocationAddress toEntity(BusinessTripLocationAddressRequest dto);

    BusinessTripLocationAddress toEntity(BusinessTripLocationAddress address, BusinessTripLocationAddressRequest dto);
}


