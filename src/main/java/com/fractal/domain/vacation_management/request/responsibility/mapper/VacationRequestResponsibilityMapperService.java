package com.fractal.domain.vacation_management.request.responsibility.mapper;

import com.fractal.domain.vacation_management.request.responsibility.VacationRequestResponsibility;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;

public interface VacationRequestResponsibilityMapperService {
    VacationRequestResponsibilityResponse toDTO(VacationRequestResponsibility responsibility);

    VacationRequestResponsibility toEntity(VacationRequestResponsibilityRequest dto);

    VacationRequestResponsibility toEntity(VacationRequestResponsibility responsibility, VacationRequestResponsibilityRequest dto);
}


