package com.fractal.domain.employee_management.citizenship.mapper;

import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipResponse;

public interface EmployeeCitizenshipMapperService {
    EmployeeCitizenshipResponse toDTO(EmployeeCitizenship employeeCitizenship);
    EmployeeCitizenship toEntity(EmployeeCitizenshipRequest dto);
    EmployeeCitizenship toEntity(EmployeeCitizenship employeeCitizenship, EmployeeCitizenshipRequest dto);
}


