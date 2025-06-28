package com.fractal.domain.navigation.action.mapper;

import com.fractal.domain.navigation.action.Action;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;

public interface ActionMapperService {
    ActionResponse toDTO(Action action);
    Action toEntity(ActionRequest dto);
    Action toEntity(Action action, ActionRequest dto);
}


