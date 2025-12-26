package com.fractal.domain.vacation_management.request;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

import java.util.List;

public interface VacationRequestService extends ApprovalWorkflowAware<Long, VacationRequest>, Cancelable<VacationRequestCancelRequest, VacationRequest> {
    VacationRequest create(VacationRequestRequest dto);

    List<VacationRequest> getAll();

    VacationRequest getById(Long id);

    List<VacationRequest> getAllByEmployeeId(Long employeeId);

    VacationRequest update(Long id, VacationRequestRequest dto);

    void deleteById(Long id);
    void close(Long id);

    VacationRequestResponse toDTO(VacationRequest vacationRequest);

    VacationRequest save(VacationRequest vacationRequest);


}
