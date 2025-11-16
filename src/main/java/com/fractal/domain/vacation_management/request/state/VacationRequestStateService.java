package com.fractal.domain.vacation_management.request.state;

import com.fractal.domain.vacation_management.request.VacationRequest;

import java.util.List;

public interface VacationRequestStateService {
    VacationRequestState create(VacationRequest vacationRequest);

    List<VacationRequestState> getAll();

    VacationRequestState getById(Long id);

    List<VacationRequestState> getAllByVacationRequestId(Long vacationRequestId);

    VacationRequestState update(Long id, VacationRequest vacationRequest);

    void deleteById(Long id);

    VacationRequestStateResponse toDTO(VacationRequestState state);

    VacationRequestState save(VacationRequestState state);
}
