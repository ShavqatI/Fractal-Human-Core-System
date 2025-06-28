package com.fractal.domain.navigation.action.type;

import com.fractal.domain.navigation.action.type.dto.ActionTypeRequest;
import com.fractal.domain.navigation.action.type.dto.ActionTypeResponse;

import java.util.List;

public interface ActionTypeService {

    ActionType create(ActionTypeRequest dto);
    List<ActionType> getAll();
    ActionType getByCode(String code);
    ActionType getById(Long id);
    ActionType update(Long id, ActionTypeRequest dto);
    void deleteById(Long id);
    ActionTypeResponse toDTO(ActionType actionType);
}
