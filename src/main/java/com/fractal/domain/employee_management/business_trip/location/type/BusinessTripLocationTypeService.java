package com.fractal.domain.employee_management.business_trip.location.type;

import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeRequest;
import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeResponse;

import java.util.List;

public interface BusinessTripLocationTypeService {
    BusinessTripLocationType create(BusinessTripLocationTypeRequest dto);

    List<BusinessTripLocationType> getAll();

    BusinessTripLocationType getByCode(String code);

    BusinessTripLocationType getById(Long id);

    BusinessTripLocationType update(Long id, BusinessTripLocationTypeRequest dto);

    void deleteById(Long id);

    BusinessTripLocationTypeResponse toDTO(BusinessTripLocationType businessTripLocationType);
}
