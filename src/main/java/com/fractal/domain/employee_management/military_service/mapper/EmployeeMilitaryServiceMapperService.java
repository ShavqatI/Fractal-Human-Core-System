package com.fractal.domain.employee_management.military_service.mapper;

import com.fractal.domain.employee_management.military_service.EmployeeMilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

public interface EmployeeMilitaryServiceMapperService {
    MilitaryServiceResponse toDTO(EmployeeMilitaryService militaryService);
    EmployeeMilitaryService toEntity(MilitaryServiceRequest dto);
    EmployeeMilitaryService toEntity(EmployeeMilitaryService militaryService, MilitaryServiceRequest dto);
}


