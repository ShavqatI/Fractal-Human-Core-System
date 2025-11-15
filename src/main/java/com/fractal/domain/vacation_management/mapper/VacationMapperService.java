package com.fractal.domain.vacation_management.mapper;

import com.fractal.domain.vacation_management.Vacation;
import com.fractal.domain.vacation_management.dto.VacationRequest;
import com.fractal.domain.vacation_management.dto.VacationResponse;

public interface VacationMapperService {
    VacationResponse toDTO(Vacation vacation);
    Vacation toEntity(VacationRequest dto);
    Vacation toEntity(Vacation vacation, VacationRequest dto);
}


