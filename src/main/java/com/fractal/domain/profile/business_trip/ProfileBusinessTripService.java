package com.fractal.domain.profile.business_trip;

import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;

import java.util.List;

public interface ProfileBusinessTripService {
    BusinessTrip create(ProfileBusinessTripRequest dto);
    List<BusinessTrip> getAll();
    BusinessTrip getById(Long id);
    BusinessTrip update(Long id, ProfileBusinessTripRequest dto);
    void deleteById(Long id);
    void close(Long id);
    BusinessTrip review(Long id);
    BusinessTripResponse toDTO(BusinessTrip businessTrip);

}
