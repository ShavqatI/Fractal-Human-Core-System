package com.fractal.domain.vacation_management.request.mapper;

import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;

public interface VacationRequestMapperService {
    VacationRequestResponse toDTO(VacationRequest vacationRequest);

    VacationRequest toEntity(VacationRequestRequest dto);

    VacationRequest toEntity(VacationRequest vacationRequest, VacationRequestRequest dto);
}


