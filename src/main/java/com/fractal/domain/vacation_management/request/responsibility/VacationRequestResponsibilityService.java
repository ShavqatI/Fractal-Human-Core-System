package com.fractal.domain.vacation_management.request.responsibility;

import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;

import java.util.List;

public interface VacationRequestResponsibilityService {

    VacationRequestResponsibility create(Long vacationRequestId, VacationRequestResponsibilityRequest dto);
    List<VacationRequestResponsibility> getAllByVacationRequestId(Long vacationRequestId);
    VacationRequestResponsibility getById(Long vacationRequestId , Long id);
    VacationRequestResponsibility update(Long vacationRequestId, Long id, VacationRequestResponsibilityRequest dto);
    void delete(Long vacationRequestId,Long id);
    VacationRequestResponsibilityResponse toDTO(VacationRequestResponsibility vacationRequestResponsibility);

}
