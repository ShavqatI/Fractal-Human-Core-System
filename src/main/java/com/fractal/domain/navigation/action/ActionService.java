package com.fractal.domain.navigation.action;

import com.fractal.domain.navigation.action.dto.ActionCompactResponse;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;

import java.util.List;

public interface ActionService {
    Action create(ActionRequest dto);

    List<Action> getAll();

    Action getByUrl(String url);

    Action getById(Long id);

    Action update(Long id, ActionRequest dto);

    void deleteById(Long id);

    ActionResponse toDTO(Action action);

    ActionCompactResponse toCompactDTO(Action action);
}
