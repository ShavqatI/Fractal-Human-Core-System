package com.fractal.domain.employee_management.business_trip;

import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;

import java.util.List;

public interface BusinessTripService {
    BusinessTrip create(BusinessTripRequest dto);
    List<BusinessTrip> getAll();
    BusinessTrip getById(Long id);
    List<BusinessTrip>  getAllByEmployeeId(Long employeeId);
    BusinessTrip update(Long id, BusinessTripRequest dto);
    void deleteById(Long id);
    BusinessTripResponse toDTO(BusinessTrip businessTrip);
    BusinessTrip save(BusinessTrip businessTrip);

}
