package com.fractal.domain.profile.subordinate.vacation.request;

import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

import java.util.List;

public interface SubordinateVacationRequestService {
    List<VacationRequest> getAll();
    VacationRequest getById(Long id);
    VacationRequest update(Long id, SubordinateVacationRequestRequest dto);
    VacationRequestResponse toDTO(VacationRequest vacationRequest);
    VacationRequest approve(Long id);
}
