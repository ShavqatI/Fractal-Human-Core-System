package com.fractal.domain.navigation.menu.action.mapper;

import com.fractal.domain.navigation.menu.action.MenuAction;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;

public interface MenuActionMapperService {
    MenuActionResponse toDTO(MenuAction menuAction);
    MenuAction toEntity(MenuActionRequest dto);
    MenuAction toEntity(MenuAction menuAction, MenuActionRequest dto);
}


