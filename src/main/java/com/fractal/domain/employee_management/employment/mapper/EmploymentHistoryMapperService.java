package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.employee_management.employment.EmploymentHistory;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;

public interface EmploymentHistoryMapperService {
    EmploymentHistoryResponse toDTO(EmploymentHistory employmentHistory);
    EmploymentHistory toEntity(EmploymentHistoryRequest dto);
    EmploymentHistory toEntity(EmploymentHistory employmentHistory, EmploymentHistoryRequest dto);
}


