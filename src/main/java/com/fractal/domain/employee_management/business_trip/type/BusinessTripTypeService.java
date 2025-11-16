package com.fractal.domain.employee_management.business_trip.type;

import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeRequest;
import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeResponse;

import java.util.List;

public interface BusinessTripTypeService {

    BusinessTripType create(BusinessTripTypeRequest dto);

    List<BusinessTripType> getAll();

    BusinessTripType getByCode(String code);

    BusinessTripType getById(Long id);

    BusinessTripType update(Long id, BusinessTripTypeRequest dto);

    void deleteById(Long id);

    BusinessTripTypeResponse toDTO(BusinessTripType businessTripType);
}
