package com.fractal.domain.employment.work_experience.separation_reason.mapper;

import com.fractal.domain.employment.work_experience.separation_reason.SeparationReason;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonCompactResponse;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonResponse;

public interface SeparationReasonMapperService {
    SeparationReasonResponse toDTO(SeparationReason separationReason);
    SeparationReason toEntity(SeparationReasonRequest dto);
    SeparationReason toEntity(SeparationReason separationReason, SeparationReasonRequest dto);
}


