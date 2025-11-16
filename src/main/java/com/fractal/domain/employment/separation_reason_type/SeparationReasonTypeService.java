package com.fractal.domain.employment.separation_reason_type;

import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeCompactResponse;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeRequest;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeResponse;

import java.util.List;

public interface SeparationReasonTypeService {

    SeparationReasonType create(SeparationReasonTypeRequest dto);

    List<SeparationReasonType> getAll();

    SeparationReasonType getByCode(String code);

    SeparationReasonType getById(Long id);

    SeparationReasonType update(Long id, SeparationReasonTypeRequest dto);

    void deleteById(Long id);

    SeparationReasonTypeResponse toDTO(SeparationReasonType separationReasonType);

    SeparationReasonTypeCompactResponse toCompactDTO(SeparationReasonType separationReasonType);

    SeparationReasonType addChild(Long id, SeparationReasonTypeRequest dto);

    SeparationReasonType updateChild(Long id, Long childId, SeparationReasonTypeRequest dto);

    void deleteChild(Long id, Long childId);
}
