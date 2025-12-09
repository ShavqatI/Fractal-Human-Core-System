package com.fractal.domain.employee_management.business_trip.purpose;

import com.fractal.domain.employee_management.business_trip.purpose.dto.BusinessTripPurposeRequest;
import com.fractal.domain.employee_management.business_trip.purpose.dto.BusinessTripPurposeResponse;

import java.util.List;

public interface BusinessTripPurposeService {

    BusinessTripPurpose create(BusinessTripPurposeRequest dto);

    List<BusinessTripPurpose> getAll();

    BusinessTripPurpose getByCode(String code);

    BusinessTripPurpose getById(Long id);

    BusinessTripPurpose update(Long id, BusinessTripPurposeRequest dto);

    void deleteById(Long id);

    BusinessTripPurposeResponse toDTO(BusinessTripPurpose businessTripPurpose);
}
