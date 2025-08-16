package com.fractal.domain.employee_management.citizenship.mapper;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;

public interface EmployeeCitizenshipMapperService {
    CitizenshipResponse toDTO(EmployeeCitizenship citizenship);
    EmployeeCitizenship toEntity(CitizenshipRequest dto);
    EmployeeCitizenship toEntity(EmployeeCitizenship citizenship, CitizenshipRequest dto);
}


