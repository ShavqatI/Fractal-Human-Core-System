package com.fractal.domain.profile.subordinate.vacation.request;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.profile.subordinate.business_trip.SubordinateBusinessTripRequest;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

import java.util.List;

public interface SubordinateVacationRequestService extends ApprovalWorkflowAware<Long,VacationRequest>, Cancelable<VacationRequestCancelRequest, VacationRequest> {
    VacationRequest create(SubordinateVacationRequestRequest dto);
    List<VacationRequest> getAll();
    VacationRequest getById(Long id);
    VacationRequest update(Long id, SubordinateVacationRequestRequest dto);
    VacationRequestResponse toDTO(VacationRequest vacationRequest);
    void deleteById(Long id);
    void close(Long id);
}
