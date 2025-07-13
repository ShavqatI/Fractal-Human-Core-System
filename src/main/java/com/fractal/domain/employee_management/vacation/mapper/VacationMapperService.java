package com.fractal.domain.employee_management.vacation.mapper;

import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import com.fractal.domain.employee_management.vacation.Vacation;
import com.fractal.domain.employee_management.vacation.dto.VacationRequest;
import com.fractal.domain.employee_management.vacation.dto.VacationResponse;

public interface VacationMapperService {
    VacationResponse toDTO(Vacation vacation);
    Vacation toEntity(VacationRequest dto);
    Vacation toEntity(Vacation vacation, VacationRequest dto);
}


