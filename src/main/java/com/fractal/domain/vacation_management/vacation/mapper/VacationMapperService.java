package com.fractal.domain.vacation_management.vacation.mapper;

import com.fractal.domain.vacation_management.vacation.Vacation;
import com.fractal.domain.vacation_management.vacation.dto.VacationRequest;
import com.fractal.domain.vacation_management.vacation.dto.VacationResponse;

public interface VacationMapperService {
    VacationResponse toDTO(Vacation vacation);

    Vacation toEntity(VacationRequest dto);

    Vacation toEntity(Vacation vacation, VacationRequest dto);
}


