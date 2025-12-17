package com.fractal.domain.profile.vacation.request;

import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

import java.util.List;

public interface ProfileVacationRequestService {
    VacationRequest create(ProfileVacationRequestRequest dto);
    List<VacationRequest> getAll();
    VacationRequest getById(Long id);
    VacationRequest update(Long id, ProfileVacationRequestRequest dto);
    void deleteById(Long id);
    void close(Long id);
    VacationRequestResponse toDTO(VacationRequest vacationRequest);
    VacationRequest review(Long id);
}
