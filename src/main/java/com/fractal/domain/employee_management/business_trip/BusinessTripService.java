package com.fractal.domain.employee_management.business_trip;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;

import java.nio.file.Path;
import java.util.List;

public interface BusinessTripService extends ApprovalWorkflowAware<Long,BusinessTrip>, Cancelable<Long,BusinessTrip> {
    BusinessTrip create(BusinessTripRequest dto);
    List<BusinessTrip> getAll();
    BusinessTrip getById(Long id);
    List<BusinessTrip> getAllByEmployeeId(Long employeeId);
    BusinessTrip update(Long id, BusinessTripRequest dto);
    void deleteById(Long id);
    void close(Long id);
    Path passport(Long id);
    BusinessTripResponse toDTO(BusinessTrip businessTrip);
    BusinessTrip save(BusinessTrip businessTrip);

    void activate(Long id);
}
