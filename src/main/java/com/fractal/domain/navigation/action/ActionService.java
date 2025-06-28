package com.fractal.domain.navigation.action;

import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;

import java.util.List;

public interface ActionService {
    Action create(ActionRequest dto);
    List<Action> getAll();
    Action getByUrl(String url);
    Action getById(Long id);
    Action update(Long id, ActionRequest dto);
    void deleteById(Long id);
    ActionResponse toDTO(Action action);
}
