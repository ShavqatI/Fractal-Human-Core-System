package com.fractal.domain.profile.subordinate.business_trip;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripCancelRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;

import java.nio.file.Path;
import java.util.List;

public interface SubordinateBusinessTripService extends ApprovalWorkflowAware<Long,BusinessTrip>, Cancelable<BusinessTripCancelRequest,BusinessTrip> {
    BusinessTrip create(SubordinateBusinessTripRequest dto);
    List<BusinessTrip> getAll();
    BusinessTrip getById(Long id);
    BusinessTrip update(Long id, SubordinateBusinessTripRequest dto);
    void deleteById(Long id);
    void close(Long id);
    Path passport(Long id);
    BusinessTripResponse toDTO(BusinessTrip businessTrip);

}
