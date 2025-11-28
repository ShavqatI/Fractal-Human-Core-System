package com.fractal.domain.vacation_management.request.education;

import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationRequest;
import com.fractal.domain.vacation_management.request.education.dto.VacationRequestEducationResponse;

import java.util.List;


public interface VacationRequestEducationService {
    VacationRequestEducation create(Long vacationRequestId, VacationRequestEducationRequest dto);

    List<VacationRequestEducation> getAllByVacationRequestId(Long vacationRequestId);

    VacationRequestEducation getById(Long vacationRequestId, Long id);

    VacationRequestEducation getById(Long id);

    VacationRequestEducation update(Long vacationRequestId, Long id, VacationRequestEducationRequest dto);

    void delete(Long vacationRequestId, Long id);

    VacationRequestEducationResponse toDTO(VacationRequestEducation vacationRequestEducation);
}
