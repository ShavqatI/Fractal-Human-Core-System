package com.fractal.domain.employment.internal.compensation.mapper;

import com.fractal.domain.employment.internal.compensation.CompensationComponent;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentResponse;

public interface CompensationComponentMapperService {
    CompensationComponentResponse toDTO(CompensationComponent agreement);
    CompensationComponent toEntity(CompensationComponentRequest dto);
    CompensationComponent toEntity(CompensationComponent agreement, CompensationComponentRequest dto);
}


