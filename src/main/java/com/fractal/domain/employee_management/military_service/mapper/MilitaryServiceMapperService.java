package com.fractal.domain.employee_management.military_service.mapper;

import com.fractal.domain.employee_management.military_service.MilitaryService;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.employee_management.military_service.dto.MilitaryServiceResponse;

public interface MilitaryServiceMapperService {
    MilitaryServiceResponse toDTO(MilitaryService militaryService);
    MilitaryService toEntity(MilitaryServiceRequest dto);
    MilitaryService toEntity(MilitaryService militaryService, MilitaryServiceRequest dto);
}


