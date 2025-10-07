package com.fractal.domain.employment.separation_reason;

import com.fractal.domain.employment.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.separation_reason.dto.SeparationReasonResponse;

import java.util.List;

public interface SeparationReasonService {
    SeparationReason create(Long employmentId, SeparationReasonRequest dto);
    List<SeparationReason> getAllByEmploymentId(Long employmentId);
    SeparationReason getById(Long employmentId , Long id);
    SeparationReason update(Long employmentId, Long id, SeparationReasonRequest dto);
    void delete(Long employmentId, Long id);
    SeparationReasonResponse toDTO(SeparationReason separationReason);
}
