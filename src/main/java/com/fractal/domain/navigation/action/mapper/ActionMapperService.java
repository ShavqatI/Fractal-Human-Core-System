package com.fractal.domain.navigation.action.mapper;

import com.fractal.domain.navigation.action.Action;
import com.fractal.domain.navigation.action.dto.ActionCompactResponse;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;

public interface ActionMapperService {
    ActionResponse toDTO(Action action);
    ActionCompactResponse toCompactDTO(Action action);
    Action toEntity(ActionRequest dto);
    Action toEntity(Action action, ActionRequest dto);
}


