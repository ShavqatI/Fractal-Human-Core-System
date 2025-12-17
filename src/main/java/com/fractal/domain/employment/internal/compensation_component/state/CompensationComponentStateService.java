package com.fractal.domain.employment.internal.compensation_component.state;

import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;

import java.util.List;

public interface CompensationComponentStateService {
    CompensationComponentState create(CompensationComponent compensationComponent);

    List<CompensationComponentState> getAll();

    CompensationComponentState getById(Long id);

    List<CompensationComponentState> getAllByCompensationComponentId(Long compensationComponentId);

    CompensationComponentState update(Long id, CompensationComponent compensationComponent);

    void deleteById(Long id);

    CompensationComponentStateResponse toDTO(CompensationComponentState state);

    CompensationComponentState save(CompensationComponentState state);
}
