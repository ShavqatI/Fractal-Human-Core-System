package com.fractal.domain.employee_management.relative.mapper;

import com.fractal.domain.employee_management.relative.Relative;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;

public interface RelativeMapperService {
    RelativeResponse toDTO(Relative relative);
    Relative toEntity(RelativeRequest dto);
    Relative toEntity(Relative relative, RelativeRequest dto);
}


