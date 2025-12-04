package com.fractal.domain.organization_management.position;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.order.employment.EmploymentOrder;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.organization_management.position.dto.PositionCompactResponse;
import com.fractal.domain.organization_management.position.dto.PositionRequest;
import com.fractal.domain.organization_management.position.dto.PositionResponse;

import java.util.List;

public interface PositionService extends ApprovalWorkflowAware<Long, Position> {
    Position create(PositionRequest dto);
    void create(List<PositionRequest> dto);

    List<Position> getAll();

    Position getByCode(String code);

    Position getById(Long id);

    Position update(Long id, PositionRequest dto);
    Position close(Long id, PositionRequest dto);

    void deleteById(Long id);
    PositionResponse toDTO(Position position);

    PositionCompactResponse toCompactDTO(Position position);
}
