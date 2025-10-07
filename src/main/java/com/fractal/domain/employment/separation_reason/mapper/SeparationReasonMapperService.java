package com.fractal.domain.employment.separation_reason.mapper;

import com.fractal.domain.employment.separation_reason.SeparationReason;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonResponse;

public interface SeparationReasonMapperService {
    SeparationReasonResponse toDTO(SeparationReason separationReason);
    SeparationReason toEntity(SeparationReasonRequest dto);
    SeparationReason toEntity(SeparationReason separationReason, SeparationReasonRequest dto);
}


