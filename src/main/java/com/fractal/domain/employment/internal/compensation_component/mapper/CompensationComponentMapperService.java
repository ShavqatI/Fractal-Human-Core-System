package com.fractal.domain.employment.internal.compensation_component.mapper;

import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;

public interface CompensationComponentMapperService {
    CompensationComponentResponse toDTO(CompensationComponent compensationComponent);
    CompensationComponent toEntity(CompensationComponentRequest dto);
    CompensationComponent toEntity(CompensationComponent compensationComponent, CompensationComponentRequest dto);
}


