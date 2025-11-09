package com.fractal.domain.integration.mapping.position;

import com.fractal.domain.integration.mapping.position.dto.PositionMappingRequest;
import com.fractal.domain.integration.mapping.position.dto.PositionMappingResponse;

import java.util.List;

public interface PositionMappingService {

    PositionMapping create(PositionMappingRequest dto);
    List<PositionMapping> getAll();
    PositionMapping getById(Long id);
    PositionMapping update(Long id, PositionMappingRequest dto);
    void deleteById(Long id);
    PositionMappingResponse toDTO(PositionMapping positionMapping);
}
