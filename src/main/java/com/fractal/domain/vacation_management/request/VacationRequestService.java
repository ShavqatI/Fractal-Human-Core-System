package com.fractal.domain.vacation_management.request;

import com.fractal.domain.vacation_management.dto.VacationResponse;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

import java.util.List;

public interface VacationRequestService {
    VacationRequest create(VacationRequestRequest dto);
    List<VacationRequest> getAll();
    VacationRequest getById(Long id);
    List<VacationRequest>  getAllByEmployeeId(Long employeeId);
    VacationRequest update(Long id, VacationRequestRequest dto);
    void deleteById(Long id);
    VacationRequestResponse toDTO(VacationRequest vacationRequest);
    VacationRequest save(VacationRequest vacationRequest);
}
