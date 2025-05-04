package com.fractal.domain.organization_management.position;

import com.fractal.domain.organization_management.position.dto.PositionCreate;
import com.fractal.domain.organization_management.position.dto.PositionResponse;

import java.util.List;

public interface PositionService {
    Position create(PositionCreate dto);
    List<Position> getAll();
    Position getByCode(String code);
    Position getById(Long id);
    Position update(Long id, PositionCreate dto);
    void deleteById(Long id);
    PositionResponse toDTO(Position position);
}
