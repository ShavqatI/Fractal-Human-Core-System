package com.fractal.domain.employee_management.citizenship.mapper;

import com.fractal.domain.employee_management.citizenship.Citizenship;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;

public interface CitizenshipMapperService {
    CitizenshipResponse toDTO(Citizenship citizenship);
    Citizenship toEntity(CitizenshipRequest dto);
    Citizenship toEntity(Citizenship citizenship, CitizenshipRequest dto);
}


